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

'STEP - 알림 [허용] 선택'
Mobile.tap(findTestObject('Scenario_1/btn_permission_allow_alarm'), GlobalVariable.fixedTime)

// -----------------------------------------------------------------------------------------------------------------------------------------

'STEP - 위치 권한 안내 화면 [확인] 버튼 선택'
Mobile.tap(findTestObject('Scenario_1/btn_OK'), GlobalVariable.fixedTime)

'STEP - 위치 권한 [앱 사용 중에만 허용] 선택'
Mobile.tap(findTestObject('Scenario_1/btn_permission_allow_foreground_only'), GlobalVariable.fixedTime)

'STEP - 전화 권환 [허용] 선택'
Mobile.tap(findTestObject('Scenario_1/btn_permission_allow_phone'), GlobalVariable.fixedTime)

'기대결과 - 온보딩 화면 [둘러보기] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('Scenario_2/btn_tvSkipTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 온보딩 화면 [카카오로 시작하기] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('Scenario_2/btn_commonBtnTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 온보딩 화면 [이메일 로그인] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('Scenario_2/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

