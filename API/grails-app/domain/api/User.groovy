package api

class User {

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
    Date registered
    Date dob
    String phone
    String cell
    String PPS
    def picture = [:]

    static constraints = {
    }

    def beforeValidate() {
       // convert dates
   }
}
