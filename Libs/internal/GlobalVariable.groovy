package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile default : &#50545;ID</p>
     */
    public static Object appid
     
    /**
     * <p>Profile default : &#44256;&#51221;&#46108; &#49884;&#44036;</p>
     */
    public static Object fixedTime
     
    /**
     * <p>Profile default : apk path</p>
     */
    public static Object apk
     
    /**
     * <p></p>
     */
    public static Object user_name
     
    /**
     * <p>Profile default : &#51060;&#47700;&#51068; &#50500;&#51060;&#46356;</p>
     */
    public static Object email_id
     
    /**
     * <p>Profile default : &#51060;&#47700;&#51068; &#54056;&#49828;&#50892;&#46300;</p>
     */
    public static Object email_password
     
    /**
     * <p>Profile default : &#51088;&#46041;&#54868; &#44172;&#51221; (&#44592;&#47197;o)</p>
     */
    public static Object email_id_22
     
    /**
     * <p>Profile default : &#51088;&#46041;&#54868; &#44228;&#51221; (&#44592;&#47197;x)</p>
     */
    public static Object email_id_21
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            appid = selectedVariables['appid']
            fixedTime = selectedVariables['fixedTime']
            apk = selectedVariables['apk']
            user_name = selectedVariables['user_name']
            email_id = selectedVariables['email_id']
            email_password = selectedVariables['email_password']
            email_id_22 = selectedVariables['email_id_22']
            email_id_21 = selectedVariables['email_id_21']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
