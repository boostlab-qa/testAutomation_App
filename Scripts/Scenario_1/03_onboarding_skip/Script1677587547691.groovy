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

'STEP - [둘러보기] 선택'
Mobile.tap(findTestObject('02_onboarding/btn_onboarding_skip'), GlobalVariable.fixedTime)

'기대결과 - 마케팅 정보 수신 동의 팝업 노출'
Mobile.verifyElementVisible(findTestObject('03_home/01_home_popup/txt_maketing_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('03_home/01_home_popup/img_maketing_character'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('03_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('03_home/01_home_popup/btn_maketing_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [좋아요!] 선택'
Mobile.tap(findTestObject('03_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime)

'STEP - 이벤트 팝업 노출 시 [닫기] 선택' //이벤트 팝업은 메인 1개만 노출됩니다.
if (Mobile.waitForElementPresent(findTestObject('03_home/01_home_popup/img_event_banner'), GlobalVariable.fixedTime))
{
		Mobile.tap(findTestObject('03_home/01_home_popup/btn_event_close'), GlobalVariable.fixedTime)
}
	
//비로그인 상태 홈 화면
'기대결과 - 홈 화면 노출'
Mobile.verifyElementVisible(findTestObject('03_home/home_constraint_address'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('03_home/home_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('03_home/home_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'온보딩까지 실행했다면 true 값 적용'
GlobalVariable.run = true