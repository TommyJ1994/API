package api

class User {

    // User Attributes
    String gender
    def name = [:]
    def location = [:]
    String email
    String username
    String password
    String salt
    String md5
    String sha1
    String sha256
    Integer registered
    Integer dob
    String phone
    String cell
    String PPS
    def picture = [:]

    // User Attribute Constraints
    static constraints = {
      gender(inList: ["male", "female"])
      name(blank: false)
      location(blank: false)
      email(email: true, blank: false)
      username(maxSize: 20, blank: false)
      password(minSize: 6, blank:false)
      salt(blank: false)
      md5(maxSize: 32, minSize: 32) // MD5 hash is 128 bits or 32 Characters
      sha1(maxSize: 40, minSize: 40) // SHA-1 is 160 bits or 40 Characters
      sha256(maxSize: 64, minSize: 64) // SHA-256 is 256 bits or 64 Characters
      registered(blank: false)
      dob(blank: false)
      phone(blank: false, matches: "[0-9]{3}-[0-9]{3}-[0-9]{4}")
      cell(blank: false, matches: "[0-9]{3}-[0-9]{3}-[0-9]{4}")
      PPS(maxSize: 9, matches: "[A-Za-z0-9]+") // Less than 9 characters and contains atleast 1 letter
      picture(blank: false)
    }
}
