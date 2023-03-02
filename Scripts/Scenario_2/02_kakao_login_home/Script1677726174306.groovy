import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


'온보딩 후 홈 화면까지 진행했다면 홈 화면에서 카카오 로그인 시도'
if(GlobalVariable.run == true)
{
	'STEP - 똑닥 앱 실행'
	Mobile.startExistingApplication(GlobalVariable.appid)
	
	'STEP - 홈 로그인 영역 [시작하기] 버튼 선택'
	Mobile.tap(findTestObject('03_home/home_login'), GlobalVariable.fixedTime)
	
	'STEP - [카카오로 시작하기] 버튼 선택'
	Mobile.tap(findTestObject('02_onboarding/btn_onboarding_kakao_login'), GlobalVariable.fixedTime)
	
	'STEP - [카카오톡으로 간편로그인] 버튼 선택'
	Mobile.tap(findTestObject('02_onboarding/btn_onboarding_kakao_easy_login'), GlobalVariable.fixedTime)
	
	'기대결과 -  홈 주소영역 노출'
	Mobile.verifyElementVisible(findTestObject('03_home/home_constraint_address'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 -  홈 검색바 영역 노출'
	Mobile.verifyElementVisible(findTestObject('03_home/home_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 -  홈 로그인 유도 영역 미노출'
	Mobile.verifyElementNotVisible(findTestObject('03_home/home_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 -  홈 병원 추천(a) 영역 노출'
	Mobile.verifyElementVisible(findTestObject('03_home/home_recommend_section'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

else 
{
	'STEP - 똑닥 앱 실행'
	Mobile.startApplication(GlobalVariable.apk, true)
	
	'STEP - 알림 팝업 노출 시 [허용] 선택' //예외처리
	if(Mobile.waitForElementPresent(findTestObject('01_permission_imformation/btn_permission_allow_alarm'), GlobalVariable.fixedTime))
	{
	Mobile.tap(findTestObject('01_permission_imformation/btn_permission_allow_alarm'), GlobalVariable.fixedTime)
	}
	
	'STEP - [확인] 버튼 선택'
	Mobile.tap(findTestObject('01_permission_imformation/btn_permission_ok'), GlobalVariable.fixedTime)
	
	'STEP - 기기 액세스 팝업 노출 시 (위치/전화) 허용 선택' //예외처리
	if(Mobile.waitForElementPresent(findTestObject('01_permission_imformation/btn_permission_location_allow_foreground_only'), GlobalVariable.fixedTime))
	{
	Mobile.tap(findTestObject('01_permission_imformation/btn_permission_location_allow_foreground_only'), GlobalVariable.fixedTime)  //위치 액세스
	Mobile.tap(findTestObject('01_permission_imformation/btn_permission_call_allow'), GlobalVariable.fixedTime)  //전화 액세스
	}
	
	
}
