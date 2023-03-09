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

'STEP - 찜한 목록 [☆] 버튼 선택'
Mobile.tap(findTestObject('04_home/btn_favorite'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

//찜한 목록 미등록 상태
'기대결과 - "찜한 목록" 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('00_common/area_page_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - "찜한 병원" tab 노출'
Mobile.verifyElementVisible(findTestObject('08_favorits/txt_favorits_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - "찜한 약국" tab 노출'
Mobile.verifyElementVisible(findTestObject('08_favorits/txt_favorits_drugstore'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 미등록 화면 타이틀 노출'
Mobile.verifyElementText(findTestObject('08_favorits/area_empty_title'), '찜한 병원이 없어요.', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 미등록 화면 안내문구 노출'
Mobile.verifyElementText(findTestObject('08_favorits/area_empty_description'), '관심 병원을 찜해보세요!', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [병원 찾기] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('08_favorits/btn_favorits_find_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - [병원 찾기] 버튼 선택'
Mobile.tap(findTestObject('08_favorits/btn_favorits_find_hospital'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'기대결과 - 홈 화면 노출'
Mobile.verifyElementVisible(findTestObject('04_home/area_constraint_address'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('04_home/area_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 찜한 목록 [☆] 버튼 선택'
Mobile.tap(findTestObject('04_home/btn_favorite'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 찜한 약국 tab 선택'
Mobile.tap(findTestObject('08_favorits/txt_favorits_drugstore'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'기대결과 - 미등록 화면 타이틀 노출'
Mobile.verifyElementText(findTestObject('08_favorits/area_empty_title'), '찜한 약국이 없어요.', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 미등록 화면 안내문구 노출'
Mobile.verifyElementText(findTestObject('08_favorits/area_empty_description'), '관심 약국을 찜해보세요!', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [약국 찾기] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('08_favorits/btn_favorits_find_drugstore'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [약국 찾기] 버튼 선택'
Mobile.tap(findTestObject('08_favorits/btn_favorits_find_drugstore'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

//네이버 약국 지도 화면 노출
if(GlobalVariable.adress_name == '상동')
{
'기대결과 - "상동 약국" 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_naver_adress_title'), '상동 약국', FailureHandling.CONTINUE_ON_FAILURE)
}
else
{
'기대결과 - "여의도동 약국" 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_naver_adress_title'), '여의도동 약국', FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - [현위치] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('00_common/btn_naver_adress_current_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [연중무휴] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('00_common/btn_naver_adress_no_holiday'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - [x] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_close'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'기대결과 - 홈 화면 노출'
Mobile.verifyElementVisible(findTestObject('04_home/area_constraint_address'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('04_home/area_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//이전 페이지 이동
'STEP - 찜한 목록 [☆] 버튼 선택'
Mobile.tap(findTestObject('04_home/btn_favorite'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_back'), GlobalVariable.fixedTime)

'기대결과 - 홈 화면 노출'
Mobile.verifyElementVisible(findTestObject('04_home/area_constraint_address'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('04_home/area_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

