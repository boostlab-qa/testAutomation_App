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
		
'STEP - 홈 > 주소이름 선택'
Mobile.tap(findTestObject('05_home/area_adress_name'), GlobalVariable.fixedTime)

//주소설정 화면 노출(우리집 설정 상태)
'기대결과 - 뒤로가기 [<-] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('00_common/btn_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [편집] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - "어디에 있는 병원을 찾으세요?" 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/txt_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [현위치에서 병원 찾기] 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/btn_current_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [우리집] 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/btn_my_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [다른 위치에서 병원 찾기] 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/btn_different_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//우리집 주소 편집 페이지 이동
'STEP - [편집] 버튼 선택'
Mobile.tap(findTestObject('04_adress_setting/btn_edit'), GlobalVariable.fixedTime)

'기대결과 - 주소 편집 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '주소 편집', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_back'), GlobalVariable.fixedTime)

'기대결과 - 주소 설정 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)
//

//우리집 주소 주소설정 화면에서 편집
'STEP - [편집] 버튼 선택'
Mobile.tap(findTestObject('04_adress_setting/btn_edit'), GlobalVariable.fixedTime)

'STEP - 우리집 [수정] 버튼 선택'
Mobile.tap(findTestObject('04_adress_setting/btn_modify'), GlobalVariable.fixedTime)

'기대결과 - "주소 검색하기" 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '주소 검색하기', FailureHandling.STOP_ON_FAILURE)

'STEP - 주소 입력'
Mobile.setText(findTestObject('04_adress_setting/input_adress_search_adress'), '경기 시흥시 배곧전원로 12-1', GlobalVariable.fixedTime)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('04_adress_setting/btn_adress_search'), GlobalVariable.fixedTime)

'STEP - 도로명 주소 선택'
Mobile.tap(findTestObject('04_adress_setting/txt_adress_road_name'), GlobalVariable.fixedTime)

'기대결과 - "상세주소 입력" 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '상세주소 입력', FailureHandling.STOP_ON_FAILURE)

'기대결과 - 상세주소 입력 화면 "주소" 문구 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/txt_adress_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 상세주소 입력 화면 주소 input 편집한 주소 노출'
Mobile.verifyElementText(findTestObject('04_adress_setting/input_adress_detail_adress'), '경기 시흥시 배곧전원로 12-1 (배곧동) (15010)', FailureHandling.STOP_ON_FAILURE)

'기대결과 - 상세주소 입력 화면 "상세주소 (선택)" 문구 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/txt_adress_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 상세주소 input 노출'
Mobile.verifyElementVisible(findTestObject('04_adress_setting/input_adress_detail_adress_detail'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - {주소 이름} 문구 미노출'
Mobile.verifyElementNotVisible(findTestObject('04_adress_setting/input_adress_detail_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 이름 input 미노출'
Mobile.verifyElementNotVisible(findTestObject('04_adress_setting/input_adress_detail_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 상세주소 입력'
Mobile.setText(findTestObject('04_adress_setting/input_adress_detail_adress_detail'), '우리집 상세주소', GlobalVariable.fixedTime)

'STEP - [등록] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_complete'), GlobalVariable.fixedTime)

'기대결과 - "주소 편집" 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '주소 편집', FailureHandling.STOP_ON_FAILURE)

'기대결과 - 주소 편집 화면 수정된 우리집 주소 노출'
Mobile.verifyElementText(findTestObject('04_adress_setting/area_adress'), '경기 시흥시 배곧전원로 12-1 (배곧동) 우리집 상세주소', FailureHandling.STOP_ON_FAILURE)

'STEP - 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_back'), GlobalVariable.fixedTime)

'기대결과 - "주소 설정" 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '주소 설정', FailureHandling.STOP_ON_FAILURE)

'기대결과 - 주소 설정 화면 수정된 우리집 주소 노출'
Mobile.verifyElementText(findTestObject('04_adress_setting/area_adress'), '경기 시흥시 배곧전원로 12-1 (배곧동) 우리집 상세주소', FailureHandling.STOP_ON_FAILURE)
//

//수정된 주소 마이페이지에서 확인
'STEP - 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_back'), GlobalVariable.fixedTime)

'STEP - 마이페이지 메뉴 선택'
Mobile.tap(findTestObject('05_home/btn_menu_mypage'), GlobalVariable.fixedTime)

'STEP - [수정] 버튼 선택'
Mobile.tap(findTestObject('07_mypage/btn_mypage_edit'), GlobalVariable.fixedTime)

'기대결과 - "개인정보 수정" 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '개인정보 수정', FailureHandling.STOP_ON_FAILURE)

'기대결과 - 주소 영역에 수정된 주소 노출'
Mobile.verifyElementText(findTestObject('07_mypage/ares_privacy_adress'), '경기 시흥시 배곧전원로 12-1 (배곧동) 우리집 상세주소 (15010)', FailureHandling.STOP_ON_FAILURE)
//

//마이페이지에서 주소 수정
'STEP - 주소 영역 선택'
Mobile.tap(findTestObject('07_mypage/ares_privacy_adress'), GlobalVariable.fixedTime)

'기대결과 - "주소 검색하기" 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '주소 검색하기', FailureHandling.STOP_ON_FAILURE)

'STEP - 주소 입력'
Mobile.setText(findTestObject('04_adress_setting/input_adress_search_adress'), GlobalVariable.my_adress, GlobalVariable.fixedTime)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('04_adress_setting/btn_adress_search'), GlobalVariable.fixedTime)

'STEP - 도로명 주소 선택'
Mobile.tap(findTestObject('04_adress_setting/txt_adress_road_name'), GlobalVariable.fixedTime)

'STEP - [등록] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_complete'), GlobalVariable.fixedTime)

'기대결과 - "개인정보 수정" 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '개인정보 수정', FailureHandling.STOP_ON_FAILURE)

'STEP - 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_back'), GlobalVariable.fixedTime)

'STEP - 홈 메뉴 버튼 선택'
Mobile.tap(findTestObject('05_home/btn_menu_home'), GlobalVariable.fixedTime)

'STEP - 홈 주소이름 영역 선택'
Mobile.tap(findTestObject('05_home/area_adress_name'), GlobalVariable.fixedTime)

'기대결과 - "주소 설정" 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '주소 설정', FailureHandling.STOP_ON_FAILURE)

'기대결과 - 수정된 우리집 주소 노출'
Mobile.verifyElementText(findTestObject('04_adress_setting/area_adress'), GlobalVariable.my_adress, FailureHandling.STOP_ON_FAILURE)
//

//주소 목록 선택 - 현위치 선택
'STEP - [현위치에서 병원 찾기] 버튼 선택'
Mobile.tap(findTestObject('04_adress_setting/btn_current_location'), GlobalVariable.fixedTime)

'기대결과 - 홈 화면 주소이름 {현위치} 노출'
Mobile.verifyElementText(findTestObject('05_home/area_adress_name'), GlobalVariable.adress_name, FailureHandling.STOP_ON_FAILURE)
//

'STEP - 홈 > 주소이름 영역 선택'
Mobile.tap(findTestObject('05_home/area_adress_name'), GlobalVariable.fixedTime)

//주소 목록 선택 - 우리집 선택
'STEP - 주소 설정 화면 [우리집] 선택'
Mobile.tap(findTestObject('04_adress_setting/btn_my_home'), GlobalVariable.fixedTime)

'기대결과 - 홈 화면 주소이름 {우리집} 노출'
Mobile.verifyElementText(findTestObject('05_home/area_adress_name'), '우리집', FailureHandling.STOP_ON_FAILURE)
//

'STEP - 홈 주소이름 영역 선택'
Mobile.tap(findTestObject('05_home/area_adress_name'), GlobalVariable.fixedTime)

'STEP - 추가한 주소가 없는 경우 주소 추가'
if(Mobile.waitForElementNotPresent(findTestObject('04_adress_setting/btn_different_adress_name'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE))
{
	'STEP - [다른 위치에서 병원 찾기] 버튼 선택'
	Mobile.tap(findTestObject('04_adress_setting/btn_different_location'), GlobalVariable.fixedTime)
	
	'기대결과 - 주소 검색하기 타이틀 노출'
	Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '주소 검색하기', FailureHandling.STOP_ON_FAILURE)
	
	'STEP - 주소 입력'
	Mobile.setText(findTestObject('04_adress_setting/input_adress_search_adress'), '경기 시흥시 배곧전원로 12-1', GlobalVariable.fixedTime)
	
	'STEP - [검색] 버튼 선택'
	Mobile.tap(findTestObject('04_adress_setting/btn_adress_search'), GlobalVariable.fixedTime)
	
	'STEP - 도로명 주소 선택'
	Mobile.tap(findTestObject('04_adress_setting/txt_adress_road_name'), GlobalVariable.fixedTime)
	
	'기대결과 - 상세주소 입력 타이틀 노출'
	Mobile.verifyElementText(findTestObject('00_common/area_page_title'), '상세주소 입력', FailureHandling.STOP_ON_FAILURE)
	
	'STEP - 상세주소 입력'
	Mobile.setText(findTestObject('04_adress_setting/input_adress_detail_adress_detail'), '1234', GlobalVariable.fixedTime)
	
	'STEP - 주소이름 입력'
	Mobile.setText(findTestObject('04_adress_setting/input_adress_detail_adress_name'), 'TEST', GlobalVariable.fixedTime)
	
	'STEP - [등록] 버튼 선택'
	Mobile.tap(findTestObject('00_common/btn_complete'), GlobalVariable.fixedTime)
}

//주소 목록 선택 - 그 외 주소 선택
'STEP - 주소이름 {TEST} 선택'
Mobile.tap(findTestObject('04_adress_setting/btn_different_adress_name'), GlobalVariable.fixedTime)

'기대결과 - 홈 화면 주소이름 {TEST} 노출'
Mobile.verifyElementText(findTestObject('05_home/area_adress_name'), 'TEST', FailureHandling.STOP_ON_FAILURE)
//



