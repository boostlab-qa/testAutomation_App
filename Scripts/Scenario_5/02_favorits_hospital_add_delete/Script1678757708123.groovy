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

//찜한 병원 등록
'STEP - 홈 검색바 선택'
Mobile.tap(findTestObject('04_home/area_search_bar'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 병원명 입력'
Mobile.setText(findTestObject('09_search/input_search'), '[TEST] 똑닥마취통증의학과의원', GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 검색 결과 병원명 선택'
Mobile.tap(findTestObject('09_search/area_results_title'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 즐겨찾기 [☆] 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_favorits'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 병원상세 화면 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_back'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 검색어 삭제 [x] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search_clear'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 병원명 입력'
Mobile.setText(findTestObject('09_search/input_search'), '[TEST] 똑닥가정의학과의원', GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 검색 결과 병원명 선택'
Mobile.tap(findTestObject('09_search/area_results_title'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 즐겨찾기 [☆] 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_favorits'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)
//

'STEP - 병원상세 화면 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_back'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_back'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 찜한 목록 [☆] 버튼 선택'
Mobile.tap(findTestObject('04_home/btn_favorite'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'기대결과 - "찜한 목록" 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('00_common/area_page_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 첫번째 병원 리스트 노출'
Mobile.verifyElementVisible(findTestObject('08_favorits/area_first_hospital_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 두번째 병원 리스트 노출'
Mobile.verifyElementVisible(findTestObject('08_favorits/area_second_hospital_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - "[TEST] 똑닥가정의학과의원" 병원명 노출'
Mobile.verifyElementText(findTestObject('08_favorits/area_hospital_name'), '[TEST] 똑닥가정의학과의원', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - "[TEST] 똑닥마취통증의학과의원" 병원명 노출'
Mobile.verifyElementText(findTestObject('08_favorits/area_hospital_name'), '[TEST] 똑닥마취통증의학과의원', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_back'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

//즐겨찾기 해제
'STEP - 홈 검색바 선택'
Mobile.tap(findTestObject('04_home/area_search_bar'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 병원명 입력'
Mobile.setText(findTestObject('09_search/input_search'), '[TEST] 똑닥마취통증의학과의원', GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 검색 결과 병원명 선택'
Mobile.tap(findTestObject('09_search/area_results_title'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 즐겨찾기 [☆] 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_favorits'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_back'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 검색어 삭제 [x] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search_clear'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 병원명 입력'
Mobile.setText(findTestObject('09_search/input_search'), '[TEST] 똑닥가정의학과의원', GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 검색 결과 병원명 선택'
Mobile.tap(findTestObject('09_search/area_results_title'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 즐겨찾기 [☆] 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_favorits'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)
//

'STEP - 병원상세 화면 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_back'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_back'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 찜한 목록 [☆] 버튼 선택'
Mobile.tap(findTestObject('04_home/btn_favorite'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'기대결과 - "찜한 목록" 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('00_common/area_page_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 첫번째 병원 리스트 미노출'
Mobile.verifyElementNotVisible(findTestObject('08_favorits/area_first_hospital_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 두번째 병원 리스트 미노출'
Mobile.verifyElementNotVisible(findTestObject('08_favorits/area_second_hospital_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 미등록 화면 타이틀 노출'
Mobile.verifyElementText(findTestObject('08_favorits/area_empty_title'), '찜한 병원이 없어요.', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 미등록 화면 안내문구 노출'
Mobile.verifyElementText(findTestObject('08_favorits/area_empty_description'), '관심 병원을 찜해보세요!', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [병원 찾기] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('08_favorits/btn_find_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_back'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'기대결과 - 홈 화면 노출'
Mobile.verifyElementVisible(findTestObject('04_home/area_constraint_address'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('04_home/area_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)










