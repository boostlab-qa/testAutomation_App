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

//앱 데이터 삭제 시 주석 해제

//'STEP - 알림 팝업 노출 시 [허용] 선택'
//if(Mobile.waitForElementPresent(findTestObject('01_permission_imformation/btn_permission_allow_alarm'), GlobalVariable.fixedTime))
//{
//Mobile.tap(findTestObject('01_permission_imformation/btn_permission_allow_alarm'), GlobalVariable.fixedTime)
//}
//
//'STEP - 권한안내 화면 노출 시 온보딩 스킵'
//if(Mobile.waitForElementPresent(findTestObject('01_permission_imformation/txt_Permission_information_title'), GlobalVariable.fixedTime))
//{
//	'STEP - 권한안내 [확인] 버튼 선택'
//	Mobile.tap(findTestObject('01_permission_imformation/btn_permission_ok'), GlobalVariable.fixedTime)
//
//	'STEP - 기기 액세스 팝업 노출 시 (위치/전화) 허용 선택'
//	if(Mobile.waitForElementPresent(findTestObject('01_permission_imformation/btn_permission_location_allow_foreground_only'), GlobalVariable.fixedTime))
//	{
//		Mobile.tap(findTestObject('01_permission_imformation/btn_permission_location_allow_foreground_only'), GlobalVariable.fixedTime)  //위치 액세스
//		Mobile.tap(findTestObject('01_permission_imformation/btn_permission_call_allow'), GlobalVariable.fixedTime)  //전화 액세스
//
//	'STEP - 온보딩 [둘러보기] 선택'
//	Mobile.tap(findTestObject('02_onboarding/btn_onboarding_skip'), GlobalVariable.fixedTime)
//	}
//
//	'마케팅 수신 동의 팝업 노출 시 [좋아요!] 선택 '
//	if(Mobile.waitForElementPresent(findTestObject('04_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime))
//	{
//		Mobile.tap(findTestObject('04_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime)
//	}
//
//	'STEP - 이벤트 팝업 노출 시 [닫기] 선택' //이벤트 팝업은 메인 1개만 노출됩니다.
//	if (Mobile.waitForElementPresent(findTestObject('04_home/01_home_popup/img_event_banner'), GlobalVariable.fixedTime))
//	{
//		Mobile.tap(findTestObject('04_home/01_home_popup/btn_event_close'), GlobalVariable.fixedTime)
//	}
//}
//
//
//'마케팅 수신 동의 팝업 노출 시 [좋아요!] 선택 '
//if(Mobile.waitForElementPresent(findTestObject('04_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime))
//{
//	Mobile.tap(findTestObject('04_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime)
//}

'STEP - 이벤트 팝업 노출 시 [닫기] 선택' //이벤트 팝업은 메인 1개만 노출됩니다.
if (Mobile.waitForElementPresent(findTestObject('04_home/01_home_popup/img_event_banner'), GlobalVariable.fixedTime))
{
		Mobile.tap(findTestObject('04_home/01_home_popup/btn_event_close'), GlobalVariable.fixedTime)
}

'STEP - 이미 로그인된 경우 로그아웃 진행'
if (Mobile.waitForElementNotPresent(findTestObject('04_home/btn_home_login'), GlobalVariable.fixedTime))
{
	'STEP - 홈 마이페이지 메뉴 선택'
	Mobile.tap(findTestObject('04_home/txt_home_menu_mypage'), GlobalVariable.fixedTime)
	
	'STEP - [수정] 버튼 선택'
	Mobile.tap(findTestObject('06_mypage/btn_mypage_edit'), GlobalVariable.fixedTime)
	
	'STEP - [로그아웃] 버튼 선택'
	Mobile.tap(findTestObject('06_mypage/btn_mapage_edit_logout'), GlobalVariable.fixedTime)
	
	'STEP - 로그아웃 [확인] 버튼 선택'
	Mobile.tap(findTestObject('06_mypage/btn_mypage_edit_logout_confirm'), GlobalVariable.fixedTime)
	
}

'STEP - 마이페이지 [로그인] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_mypage_login'), GlobalVariable.fixedTime)

'기대결과 - 로그인 화면 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('02_onboarding/txt_onboarding_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 화면 닫기 [x] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('03_login/btn_login_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 화면 [카카오로 시작하기] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('02_onboarding/btn_onboarding_kakao_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 화면 [이메일 로그인] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('02_onboarding/btn_onboarding_email_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 로그인 화면 [카카오로 시작하기] 버튼 선택'
Mobile.tap(findTestObject('02_onboarding/btn_onboarding_kakao_login'), GlobalVariable.fixedTime)

'STEP - [카카오톡으로 간편로그인] 버튼 선택'
Mobile.tap(findTestObject('02_onboarding/btn_onboarding_kakao_easy_login'), GlobalVariable.fixedTime)

'기대결과 - 마이페이지 타이틀 {이름} 확인 노출'
Mobile.verifyElementText(findTestObject('06_mypage/txt_mypage_title'), GlobalVariable.user_name, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 마이페이지 [수정] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('06_mypage/btn_mypage_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 메뉴 선택'
Mobile.tap(findTestObject('04_home/txt_home_menu_home'), GlobalVariable.fixedTime)

'기대결과 - 홈 로그인 유도 영역 미노출'
Mobile.verifyElementNotVisible(findTestObject('04_home/area_home_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)




