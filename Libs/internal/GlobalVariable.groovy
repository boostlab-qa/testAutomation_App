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
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            appid = selectedVariables['appid']
            fixedTime = selectedVariables['fixedTime']
            apk = selectedVariables['apk']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
