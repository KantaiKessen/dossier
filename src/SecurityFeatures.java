class SecurityFeatures{
    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            int end =0;
            int i=0;
            while (end==0) {
                
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
                if(i<array.length)
                {
                    end++;
                }
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}