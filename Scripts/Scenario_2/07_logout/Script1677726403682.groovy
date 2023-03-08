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

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 홈 마이페이지 메뉴 선택'
Mobile.tap(findTestObject('05_home/txt_home_menu_mypage'), GlobalVariable.fixedTime)

'STEP - 비로그인 시 로그인 진행'
if (Mobile.waitForElementPresent(findTestObject('07_mypage/btn_mypage_login'), GlobalVariable.fixedTime))
{
	'STEP - 마이페이지 [로그인] 버튼 선택'
	Mobile.tap(findTestObject('07_mypage/btn_mypage_login'), GlobalVariable.fixedTime)
	
	'STEP - 로그인 화면 [카카오로 시작하기] 버튼 선택'
	Mobile.tap(findTestObject('02_onboarding/btn_onboarding_kakao_login'), GlobalVariable.fixedTime)
	
	'STEP - [카카오톡으로 간편로그인] 버튼 선택'
	Mobile.tap(findTestObject('02_onboarding/btn_onboarding_kakao_easy_login'), GlobalVariable.fixedTime)
}

'STEP - [수정] 버튼 선택'
Mobile.tap(findTestObject('07_mypage/btn_mypage_edit'), GlobalVariable.fixedTime)

'STEP - [로그아웃] 버튼 선택'
Mobile.tap(findTestObject('07_mypage/btn_mapage_edit_logout'), GlobalVariable.fixedTime)

'STEP - 로그아웃 [확인] 버튼 선택'
Mobile.tap(findTestObject('07_mypage/btn_mypage_edit_logout_confirm'), GlobalVariable.fixedTime)

'기대결과 - 마이페이지 타이틀 {마이페이지} 노출'
Mobile.verifyElementText(findTestObject('07_mypage/txt_mypage_title'), '마이페이지', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 마이페이지 [로그인] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('07_mypage/btn_mypage_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 메뉴 선택'
Mobile.tap(findTestObject('05_home/txt_home_menu_home'), GlobalVariable.fixedTime)

'기대결과 - 홈 로그인 유도 영역 노출'
Mobile.verifyElementVisible(findTestObject('05_home/area_home_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 병원 추천(a) 영역 미노출'
Mobile.verifyElementNotVisible(findTestObject('05_home/area_home_recommend'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)


