package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {


	Properties prop = new Properties();

	public ReadPropertyFile() {
		InputStream input = ReadPropertyFile.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String getCMLDDBconnection() {return prop.getProperty("databaseUrl");}

	public String getDBusername() {return prop.getProperty("dbusername");}

	public String getCGDBusername() {return prop.getProperty("cGdataBaseUsername");}

	public String getCMLDDBpassword() {return prop.getProperty("dbpasswordDEC");}

	public String getCMMDDBconnection() {return prop.getProperty("dataBaseUrlCMMD");}

	public String getCMMDDBpassword() {return prop.getProperty("dataBasePasswordCMMD");}

	public String getCM2DDBconnection() {return prop.getProperty("dataBaseUrlCM2D");}

	public String getCM2DDBpassword() {return prop.getProperty("dataBasePasswordCM2D");}

	public String getCM3DDBconnection() {return prop.getProperty("dataBaseUrlCM3D");}

	public String getCM3DDBpassword() {return prop.getProperty("dataBasePasswordCM3D");}

	public String getCMQDDBconnection() {return prop.getProperty("dataBaseUrlCMQD");}

	public String getCMQDDBpassword() {return prop.getProperty("dataBasePasswordCMQD");}


	public String getcm5d() {return prop.getProperty("cm5dUrl");}

	public String getcm1d() {return prop.getProperty("cm1dUrl");}

	public String getcm1dUsername() {return prop.getProperty("cm1dUsername");}

	public String getcm1dPassword() {return prop.getProperty("cm1dPassword");}

	public String getcm5dUsername() {
		return prop.getProperty("cm5dUsername");
	}

	public String getcm5dPassword() {
		return prop.getProperty("cm5dPassword");
	}

	public String getcm2d() {return prop.getProperty("cm2dUrl");}

	public String getcm2dUsername() {return prop.getProperty("cm2dUsername");}

	public String getcm2dUserName2() {return prop.getProperty("cm2dUsernameA");}

	public String getcm2dPassword2() {return prop.getProperty("cm2dPasswordA");}

	public String getcm2dPassword() {return prop.getProperty("cm2dPassword");}

	public String getcm3dUserName2() {return prop.getProperty("cm3dUsernameA");}

	public String getcm3dPassword2() {return prop.getProperty("cm3dPasswordA");}

	public String getcm3d() {return prop.getProperty("cm3dUrl");}

	public String getcm3dUsername() {return prop.getProperty("cm3dUsername");}

	public String getcm3dPassword() {return prop.getProperty("cm3dPassword");}

	public String getcm8d() {return prop.getProperty("cm8dUrl");}

	public String getcm8dUsername() {return prop.getProperty("cm8dUsername");}

	public String getcm8dPassword() {return prop.getProperty("cm8dPassword");}

	public String getcmzd() {return prop.getProperty("cmzdUrl");}

	public String getcmzdUsername() {return prop.getProperty("cmzdUsername");}

	public String getcmzdPassword() {return prop.getProperty("cmzdPassword");}

	public String getcmzdUserName2() {return prop.getProperty("cmzdUsernameA");}

	public String getcmzdPassword2() {return prop.getProperty("cmzdPasswordA");}

	public String getcmmdUserNameA() {return prop.getProperty("cmmdUserNameA");}

	public String getcmmdPasswordA() {return prop.getProperty("cmmdPassword");}

	public String getcmmdClerkUserName() {return prop.getProperty("cmmdClerkUserName");}

	public String getcmmdClerkPassword() {return prop.getProperty("cmmdClerkPassword");}

	public String getcmmdCaseyUserName() {return prop.getProperty("cmmdCaseyUserName");}

	public String getcmmdCaseyPassword() {return prop.getProperty("cmmdCaseyPassword");}

	public String getcmmdNewUserName() {return prop.getProperty("cmmdNewUserName");}

	public String getcmmdNewPassword() {return prop.getProperty("cmmdNewPassword");}

	public String getcmmd() {return prop.getProperty("cmmdUrl");}

	public String getcmnd() {return prop.getProperty("cmndUrl");}

	public String getcmndUserName() {return prop.getProperty("cmndUserName");}

	public String getcmndPassword() {return prop.getProperty("cmndPassword");}

	public String getcmsd() {return prop.getProperty("cmsdUrl");}

	public String getcmsdUserNameA() {return prop.getProperty("cmsdUserNameA");}

	public String getcmsdPasswordA() {return prop.getProperty("cmsdPasswordA");}

	public String getcm3b() {return prop.getProperty("cm3bUrl");}

	public String getcm3bUserName() {return prop.getProperty("cm3bUserName");}

	public String getcm3bPassword() {return prop.getProperty("cm3bPassword");}

	public String getmollyv8() {return prop.getProperty("mollyv8Url");}

	public String getmollyv8UserName() {return prop.getProperty("mollyv8UserName");}

	public String getmollyv8Password() {return prop.getProperty("mollyv8UserPass");}

	public String getcmcdUserName() {return prop.getProperty("cmcdUserName");}

	public String getcmcdPass() {return prop.getProperty("cmcdUserPass");}

	public String getcmmb() {return prop.getProperty("cmmbUrl");}

	public String getcmmbUserNameA() {return prop.getProperty("cmmbUserNameA");}

	public String getcmmbPasswordA() {return prop.getProperty("cmmbPasswordA");}

	public String getcmrd() {return prop.getProperty("cmrdUrl");}

	public String getcmrdUsername() {return prop.getProperty("cmrdUsername");}

	public String getcmrdPassword() {return prop.getProperty("cmrdPassword");}

	public String getcmrdRepo() {return prop.getProperty("cmrdrepoUrl");}

	public String getcmrdRepoUsername() {return prop.getProperty("cmrdRepoUsername");}

	public String getcmrdRepoPassword() {return prop.getProperty("cmrdRepoPassword");}

	public String getcmcd() {return prop.getProperty("cmcdUrl");}

	public String getcmcdUsername() {return prop.getProperty("cmcdUsername");}

	public String getcmcdPassword() {return prop.getProperty("cmcdPassword");}

	public String getcmcdWeb() {return prop.getProperty("cmcdWeb");}

	public String getcmcdWebUsername() {return prop.getProperty("cmcdWebUsername");}

	public String getcmcdWebPassword() {return prop.getProperty("cmcdWebPassword");}

	public String getcmjd() {return prop.getProperty("cmjdUrl");}

	public String getcmjdUsername() {return prop.getProperty("cmjdUsername");}

	public String getcmjdPassword() {return prop.getProperty("cmjdPassword");}

	public String getcmdd() {return prop.getProperty("cmddUrl");}

	public String getcmddTestUsername() {return prop.getProperty("cmddTestUsername");}

	public String getcmddTestPassword() {return prop.getProperty("cmddTestPassword");}

	public String getcmld() {return prop.getProperty("cmldUrl");}

	public String getcmldTestUsername() {return prop.getProperty("cmldUsername");}

	public String getcmldTestPassword() {return prop.getProperty("cmldPassword");}

	public String getcmsdUsername() {return prop.getProperty("cmsdUsername");}

	public String getcmsdPassword() {return prop.getProperty("cmsdPassword");}

	public String getcmmdUsername() {return prop.getProperty("cmmdUsername");}

	public String getcmfb() {return prop.getProperty("cmfbUrl");}

	public String getcmfbUsername() {return prop.getProperty("cmfbUsername");}

	public String getcmfbPassword() {return prop.getProperty("cmfbPassword");}

	public String getcmqd() {return prop.getProperty("cmqdUrl");}

	public String getcmqdUserName() {return prop.getProperty("cmqdUserName");}

	public String getcmqdPassord() {return prop.getProperty("cmqdPassword");}

	public String getpv5d() {return prop.getProperty("pv5dUrl");}

	public String getpv5dUsername() {return prop.getProperty("pv5dUsername");}

	public String getpv5dPassword() {return prop.getProperty("pv5dPassword");}

	public String getapTest() {return prop.getProperty("apTest");}

	public String getapUsername() {return prop.getProperty("apUsername");}

	public String getapPassword() {return prop.getProperty("apPassword");}

	public String getPacer2Durl() {return prop.getProperty("Pacer2Durl");}

	public String getPacer3Durl() {return prop.getProperty("Pacer3dUrl");}

	public String getPacerUsername() {return prop.getProperty("NgPACERUsername");}

	public String getPacerPassword() {return prop.getProperty("NgPACERPassword");}

	public String getCgPacerUsername() {return prop.getProperty("CgPACERUsername");}

	public String getCgPacerPassword() {return prop.getProperty("CgPACERPassword");}

	public String getPacerQdUrl() {return prop.getProperty("PacerQdUrl");}

	public String getPacerRedirectdUrl() {return prop.getProperty("PacerRedirectdUrl");}

	public String getPacer3dRedirectUrl() {return prop.getProperty("Pacer3dRedirectUrl");}



}
