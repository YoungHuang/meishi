package meishi

import java.security.MessageDigest

class EncryptionUtils {

  public static String encryptByMD5(String originStr) {
    MessageDigest messageDigest = MessageDigest.getInstance("MD5")
    messageDigest.update(originStr.getBytes())
    byte[] data = messageDigest.digest()
    StringBuilder str = new StringBuilder()
    String hexStr = ""
    for (int i = 0; i < data.length; i++) {
      hexStr = Integer.toHexString(data[i] & 0xFF)
      if (hexStr.length() == 1) {
        str.append("0")
      }
      str.append(hexStr)
    }
   str.toString()?.toUpperCase()
  }
}
