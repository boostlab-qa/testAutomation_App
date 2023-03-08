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

'STEP - 로그인 상태인 경우 로그아웃 진행'
if (Mobile.waitForElementNotPresent(findTestObject('05_home/btn_home_login'), GlobalVariable.fixedTime))
{
	'STEP - 홈 마이페이지 메뉴 선택'
	Mobile.tap(findTestObject('05_home/txt_home_menu_mypage'), GlobalVariable.fixedTime)
	
	'STEP - [수정] 버튼 선택'
	Mobile.tap(findTestObject('07_mypage/btn_mypage_edit'), GlobalVariable.fixedTime)
	
	'STEP - [로그아웃] 버튼 선택'
	Mobile.tap(findTestObject('07_mypage/btn_mapage_edit_logout'), GlobalVariable.fixedTime)
	
	'STEP - 로그아웃 [확인] 버튼 선택'
	Mobile.tap(findTestObject('07_mypage/btn_mypage_edit_logout_confirm'), GlobalVariable.fixedTime)
	
	'STEP - 홈 메뉴 선택'
	Mobile.tap(findTestObject('05_home/txt_home_menu_home'), GlobalVariable.fixedTime)
}

//qa22 이메일 계정 로그인
'STEP - 홈 로그인 유도 영역 [시작하기] 버튼 선택'
Mobile.tap(findTestObject('05_home/btn_home_login'), GlobalVariable.fixedTime)
	
'STEP - 로그인 화면 [이메일 로그인] 버튼 선택'
Mobile.tap(findTestObject('02_onboarding/btn_onboarding_email_login'), GlobalVariable.fixedTime)
	
'STEP - 이메일 id 입력'
Mobile.setText(findTestObject('03_login/input_login_email_id'), GlobalVariable.email_id, GlobalVariable.fixedTime)
	
'STEP - 이메일 password 입력'
Mobile.setText(findTestObject('03_login/input_login_email_password'), GlobalVariable.email_password, GlobalVariable.fixedTime)
	
'STEP - [로그인하기] 버튼 선택'
Mobile.tap(findTestObject('03_login/btn_login_email_confirm'), GlobalVariable.fixedTime)
//
		
'STEP - 홈 > 주소이름 선택'
Mobile.tap(findTestObject('05_home/txt_home_adress_name'), GlobalVariable.fixedTime)

//주소설정 화면 노출(우리집 설정 상태)
'기대결과 - 뒤로가기 [<-] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('00_common/btn_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_page_title'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [편집] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - "어디에 있는 병원을 찾으세요?" 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/txt_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [현위치에서 병원 찾기] 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/txt_current_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [우리집] 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/txt_my_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [우리집] 하단 집주소 노출'
Mobile.verifyElementText(findTestObject('04_adress_setting/area_my_home_adress'), GlobalVariable.my_adress, FailureHandling.STOP_ON_FAILURE)

'기대결과 - [다른 위치에서 병원 찾기] 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/txt_different_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - [현위치에서 병원 찾기] 버튼 선택'
Mobile.tap(findTestObject('05_home/txt_home_adress_name'), GlobalVariable.fixedTime)

'기대결과 - [다른 위치에서 병원 찾기] 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/txt_different_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)







