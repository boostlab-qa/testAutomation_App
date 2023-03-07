import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

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
Mobile.startApplication(GlobalVariable.apk, false)

'기대결과 - 이용 권한 안내 화면 "똑닥 앱 이용 권한 안내 화면" 문구 노출'
Mobile.verifyElementVisible(findTestObject('01_permission_imformation/txt_Permission_information_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 이용 권한 안내 화면 [확인] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('01_permission_imformation/btn_permission_ok'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('01_permission_imformation/btn_permission_ok'), GlobalVariable.fixedTime)

'기대결과 - 기기 위치 액세스 허용 팝업 노출'
Mobile.verifyElementVisible(findTestObject('01_permission_imformation/txt_permission_location_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('01_permission_imformation/img_permission_location_accuracy_radio_fine'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('01_permission_imformation/img_permission_location_accuracy_radio_coarse'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('01_permission_imformation/btn_permission_location_allow_foreground_only'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('01_permission_imformation/btn_permission_location_allow_one_time'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('01_permission_imformation/btn_permission_location_deny'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 기기 위치 액세스 허용안함 선택'
Mobile.tap(findTestObject('01_permission_imformation/btn_permission_location_deny'), GlobalVariable.fixedTime)

'기대결과 - 기기 전화 액세스 허용 팝업 노출'
Mobile.verifyElementVisible(findTestObject('01_permission_imformation/txt_permission_call_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('01_permission_imformation/btn_permission_call_allow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('01_permission_imformation/btn_permission_call_deny'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 기기 전화 액세스 허용 선택'
Mobile.tap(findTestObject('01_permission_imformation/btn_permission_call_allow'), GlobalVariable.fixedTime)

'기대결과 - 온보딩 화면 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('02_onboarding/txt_onboarding_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 온보딩 화면 [둘러보기] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('02_onboarding/btn_onboarding_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 온보딩 화면 [카카오로 시작하기] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('02_onboarding/btn_onboarding_kakao_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 온보딩 화면 [이메일 로그인] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('02_onboarding/btn_onboarding_email_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 온보딩 [둘러보기] 선택'
Mobile.tap(findTestObject('02_onboarding/btn_onboarding_skip'), GlobalVariable.fixedTime)

'기대결과 - 마케팅 정보 수신 동의 팝업 노출'
Mobile.verifyElementVisible(findTestObject('04_home/01_home_popup/txt_maketing_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('04_home/01_home_popup/img_maketing_character'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('04_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('04_home/01_home_popup/btn_maketing_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [좋아요!] 선택'
Mobile.tap(findTestObject('04_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime)

'STEP - 이벤트 팝업 노출 시 [오늘 그만 보기] 선택' //이벤트 팝업은 메인 1개만 노출됩니다.
if (Mobile.waitForElementPresent(findTestObject('04_home/01_home_popup/img_event_banner'), GlobalVariable.fixedTime))
{
		Mobile.tap(findTestObject('04_home/01_home_popup/btn_event_close'), GlobalVariable.fixedTime)
}

'기대결과 - 주소 설정 영역 주소이름 {역삼동} 노출'
Mobile.verifyElementText(findTestObject('04_home/txt_home_adress_name'), '역삼동', FailureHandling.STOP_ON_FAILURE)

'기대결과 - 홈 주소 영역 노출'
Mobile.verifyElementVisible(findTestObject('04_home/area_home_constraint_address'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 검색 바 노출'
Mobile.verifyElementVisible(findTestObject('04_home/area_home_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 로그인 유도 영역 노출'
Mobile.verifyElementVisible(findTestObject('04_home/area_home_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 위치 정보 제공동의 영역 노출'
Mobile.verifyElementVisible(findTestObject('04_home/area_home_location_access'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)







//