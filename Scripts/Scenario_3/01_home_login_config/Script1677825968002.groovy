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

//'STEP - 이벤트 팝업 노출 시 [닫기] 선택' 
//if (Mobile.waitForElementPresent(findTestObject('05_home/01_home_popup/img_event_banner'), GlobalVariable.fixedTime))
//{
//		Mobile.tap(findTestObject('05_home/01_home_popup/btn_event_close'), GlobalVariable.fixedTime)
//}

'STEP - 최상단 스크롤 이동'
Mobile.scrollToText('질병, 진료과, 병원을 검색해보세요.')

'STEP - 로그아웃 상태인 경우 로그인 진행'
if(Mobile.waitForElementPresent(findTestObject('05_home/area_home_login'), GlobalVariable.fixedTime))
{
	'STEP - 홈 로그인 유도 영역 [시작하기] 버튼 선택'
	Mobile.tap(findTestObject('05_home/btn_home_login'), GlobalVariable.fixedTime)
	
	'STEP - 로그인 화면 [이메일 로그인] 버튼 선택'
	Mobile.tap(findTestObject('02_onboarding/btn_onboarding_email_login'), GlobalVariable.fixedTime)

	'STEP - 이메일 id 입력'
	Mobile.setText(findTestObject('03_login/input_login_email_id'), GlobalVariable.email_id_22, GlobalVariable.fixedTime)

	'STEP - 이메일 password 입력'
	Mobile.setText(findTestObject('03_login/input_login_email_password'), GlobalVariable.email_password, GlobalVariable.fixedTime)

	'STEP - [로그인하기] 버튼 선택'
	Mobile.tap(findTestObject('03_login/btn_login_email_confirm'), GlobalVariable.fixedTime)
}

'기대결과 - 홈 주소 아이콘 노출'
Mobile.verifyElementVisible(findTestObject('05_home/icon_home_adress'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 주소 이름 영역 노출'
Mobile.verifyElementVisible(findTestObject('05_home/txt_home_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 주소 펼치기 [v] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('05_home/btn_home_adress_arrow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 주소 찜한목록 [☆] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('05_home/btn_home_favorite'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 주소 [QR] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('05_home/btn_home_qr'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 검색 바 노출'
Mobile.verifyElementVisible(findTestObject('05_home/area_home_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 검색 아이콘 노출'
Mobile.verifyElementVisible(findTestObject('05_home/icon_home_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 검색 플레이스홀더 문구 노출'
Mobile.verifyElementVisible(findTestObject('05_home/txt_home_search_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//'기대결과 - 홈 상단 배너 노출'
//Mobile.verifyElementVisible(findTestObject('05_home/area_home_top_banner'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//
//'기대결과 - 홈 상단 배너 인디케이터 노출'
//Mobile.verifyElementVisible(findTestObject('05_home/area_home_top_banner_indicator'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 컨텐츠 (투표) 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_vote_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 컨텐츠 (투표) 타이틀 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('05_home/02_contents/txt_local_hospital'), GlobalVariable.fixedTime))
	{
		'STEP - 화면 스크롤 이동'
		Mobile.scrollToText('동네 인기 병원')
	}

'기대결과 - 홈 컨텐츠 (동네 인기 병원) 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_local_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 컨텐츠 (지금 문연 병원) 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_open_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 컨텐츠 (똑닥 엄마들 추천) 이미지가 미노출 상태면 스크롤 이동'
while (true)
{
if (Mobile.waitForElementNotPresent(findTestObject('05_home/02_contents/img_mom_recommend'), GlobalVariable.fixedTime))
{
	'STEP - 화면 스크롤 이동'
	Mobile.swipe(45, 2000, 45, 1000)
}
else 
{
	break
}
}

'기대결과 - 홈 컨텐츠 (똑닥 엄마들 추천) 이미지 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/img_mom_recommend'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 컨텐츠 (진료과로 병원 찾기) 타이틀 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('05_home/02_contents/txt_find_hospital'), GlobalVariable.fixedTime))
	{
		'STEP - 화면 스크롤 이동'
		Mobile.scrollToText('진료과로 병원 찾기 🏥')
	}

'기대결과 - 홈 컨텐츠 (진료과로 병원 찾기) 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_find_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 컨텐츠 (진료과로 병원 찾기) 아이콘 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('05_home/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.fixedTime))
	{
		'STEP - 화면 스크롤 이동'
		Mobile.scrollToText('소아청소년과')
	}

'기대결과 - 홈 컨텐츠 (진료과로 병원 찾기) 아이콘 리스트 영역 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/area_find_hospital_icon'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 컨텐츠 (진료과로 병원 찾기) 소아청소년과 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 컨텐츠 (진료과로 병원 찾기) 이비인후과 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_find_hospital_otolaryngology'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 컨텐츠 (진료과로 병원 찾기) 가정의학과 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_find_hospital_family_medicine'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 컨텐츠 (진료과로 병원 찾기) 산부인과 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_find_hospital_obstetrics_gynecology'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//swip 높이 정의
'STEP - 스와이프 우측으로 이동'
int position_hospital_paediatrics = Mobile.getElementTopPosition(findTestObject('05_home/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.fixedTime)
Mobile.swipe(500, position_hospital_paediatrics, 100, position_hospital_paediatrics)

'기대결과 - 홈 컨텐츠 (진료과로 병원 찾기) 내과 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_find_hospital_medicine'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 컨텐츠 (진료과로 병원 찾기) 정형외과 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_find_hospital_orthopedics'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 스와이프 우측으로 이동'
Mobile.swipe(500, position_hospital_paediatrics, 100, position_hospital_paediatrics)

'기대결과 - 홈 컨텐츠 (진료과로 병원 찾기) 피부과 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_find_hospital_dermatology'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 컨텐츠 (진료과로 병원 찾기) 안과 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_find_hospital_ophthalmology'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 컨텐츠 (진료과로 병원 찾기) 정신건강의학과 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_find_hospital_psychiatry'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 스와이프 맨 좌측으로 이동'
Mobile.swipe(100, position_hospital_paediatrics, 1000, position_hospital_paediatrics)

'STEP - 홈 컨텐츠 (이런 병원 찾고 계신가요?) 타이틀 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('05_home/02_contents/txt_like_this_hospital'), GlobalVariable.fixedTime))
	{
		'STEP - 화면 스크롤 이동'
		Mobile.scrollToText('이런 병원 찾고 계신가요?')
	}

'기대결과 - 홈 컨텐츠 (이런 병원 찾고 계신가요?) 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_like_this_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 컨텐츠 이런 병원 찾고 계신가요?(똑닥 예약 병원) 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('05_home/02_contents/txt_like_this_hospital'), GlobalVariable.fixedTime))
	{
		'STEP - 화면 스크롤 이동'
		Mobile.scrollToText('똑닥 예약 병원')
	}

'기대결과 - 홈 컨텐츠 이런 병원 찾고 계신가요? (똑닥 예약 병원) 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_like_this_hospital_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 컨텐츠 이런 병원 찾고 계신가요? (야간진료) 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_like_this_hospital_night'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 컨텐츠 이런 병원 찾고 계신가요? (일요일 진료) 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_like_this_hospital_sunday'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//swip 높이 정의
'STEP - 스와이프 우측으로 이동'
int position_hospital_reservation = Mobile.getElementTopPosition(findTestObject('05_home/02_contents/txt_like_this_hospital_reservation'), GlobalVariable.fixedTime)
Mobile.swipe(500, position_hospital_reservation, 100, position_hospital_reservation)

'기대결과 - 홈 컨텐츠 이런 병원 찾고 계신가요? (X-ray 있는 소아과) 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_like_this_hospital_x-ray_pediatrics'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 컨텐츠 이런 병원 찾고 계신가요? (입원 가능한 소아과) 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/txt_like_this_hospital_hospitalize_pediatrics'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 스와이프 맨 좌우측으로 이동'
Mobile.swipe(100, position_hospital_reservation, 1000, position_hospital_reservation)

'STEP - 홈 컨텐츠 (영유아 검진 예약하기) 이미지가 미노출 상태면 스크롤 이동'
while (true)
{
if (Mobile.waitForElementNotPresent(findTestObject('05_home/02_contents/img_infant_check-up'), GlobalVariable.fixedTime))
{
	'STEP - 화면 스크롤 이동'
	Mobile.swipe(45, 2000, 45, 1000)
}
else
{
	break
}
}

'기대결과 - 홈 컨텐츠 (영유아 검진 예약하기) 노출'
Mobile.verifyElementVisible(findTestObject('05_home/02_contents/img_infant_check-up'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 컨텐츠 위치로 스크롤'
Mobile.scrollToText('그때 그 병원, 다시 방문하시겠어요?')

'STEP - 홈 병원 추천(a) 리스트 영역 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('05_home/area_home_recommend_hospital'), GlobalVariable.fixedTime))
	{
		'STEP - 화면 스크롤 이동'
		Mobile.swipe(45, 1080, 45, 700)
	}

'기대결과 - 홈 병원 추천(a) 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('05_home/txt_home_recommend_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 병원 추천(a) 병원 리스트 영역 노출'
Mobile.verifyElementVisible(findTestObject('05_home/area_home_recommend_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 내 주변 약국 찾기 영역 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('05_home/txt_home_find_pharmacy'), GlobalVariable.fixedTime))
	{
		'STEP - 화면 스크롤 이동'
		Mobile.swipe(45, 1080, 45, 700)
	}
	
'기대결과 - 홈 내 주변 약국 찾기 타이틀 노출'
Mobile.verifyElementVisible(findTestObject('05_home/txt_home_find_pharmacy'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 내 주변 약국 찾기 안내문구 노출'
Mobile.verifyElementVisible(findTestObject('05_home/txt_home_find_pharmacy_guide'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 최상단 스크롤 이동'
Mobile.scrollToText('질병, 진료과, 병원을 검색해보세요.')

//'기대결과 - 홈 하단 배너 영역 노출'
//Mobile.verifyElementVisible(findTestObject('05_home/area_home_lower_banner'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)


