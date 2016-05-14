package api

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test User creation using valid data"() {
		given: "a new User Object is created"
      def name = [title: "mr", first: "john", last: "williams"]
      def location = [street: "5857 woodlawn avenue", city: "Westport", state: "alaska", zip: 71280]
      def picture = [large: "https://randomuser.me/api/portraits/men/75.jpg", medium: "https://randomuser.me/api/portraits/med/men/75.jpg", thumbnail: "https://randomuser.me/api/portraits/thumb/men/75.jpg"]

      def user = new User(gender: 'male',
  			name: name,
        location: location,
        email: "john@gmail.com",
        username: "john100",
        password: "123457",
        salt: "HsxzewdQ",
        md5: "5809e5fda81eed34bad9ca6eff414924",
        sha1: "6c95f0d9210e88028074d4baaeefc3d6c830a9a3",
        sha256: "f92fc585c017d093b03dba898162613380f137f934637c5bf9050fe68c103c54",
        registered: 1180746503,
        dob: 1028583070,
        phone: "041-252-0953",
        cell: "081-567-1935",
        PPS: "2470896T",
        picture: picture
        )

		when: "the User is saved"
		  user.save(flush:true)

		then: "the number of Users should be equals to 1"
			assertEquals 1, User.list().size()
    }

    void "Test Invalid Gender"() {
		given: "a new User Object is created"
      def name = [title: "mrs", first: "alice", last: "jones"]
      def location = [street: "5857 woodlawn avenue", city: "Westport", state: "alaska", zip: 71280]
      def picture = [large: "https://randomuser.me/api/portraits/woman/75.jpg", medium: "https://randomuser.me/api/portraits/med/woman/75.jpg", thumbnail: "https://randomuser.me/api/portraits/thumb/woman/75.jpg"]

      def user = new User(gender: 'woman',
  			name: name,
        location: location,
        email: "alice@hotmail.com",
        username: "alice2009",
        password: "123457",
        salt: "HsxzewdQ",
        md5: "5809e5fda81eed34bad9ca6eff414924",
        sha1: "6c95f0d9210e88028074d4baaeefc3d6c830a9a3",
        sha256: "f92fc585c017d093b03dba898162613380f137f934637c5bf9050fe68c103c54",
        registered: 1180746503,
        dob: 1028583070,
        phone: "041-252-0953",
        cell: "081-567-1935",
        PPS: "2470896T",
        picture: picture
        )

		when: "the User does not pass the validation test"
		  user.save(flush:true)

		then: "the number of Users should be equals to 0"
			assertEquals 0, User.list().size()
    }

    void "Test Invalid Email Address"() {
		given: "a new User Object is created"
      def name = [title: "mr", first: "tim", last: "wall"]
      def location = [street: "5857 woodlawn avenue", city: "Westport", state: "alaska", zip: 71280]
      def picture = [large: "https://randomuser.me/api/portraits/woman/75.jpg", medium: "https://randomuser.me/api/portraits/med/woman/75.jpg", thumbnail: "https://randomuser.me/api/portraits/thumb/woman/75.jpg"]

      def user = new User(gender: 'male',
  			name: name,
        location: location,
        email: "tim.com",
        username: "timBuck2",
        password: "123457",
        salt: "AsxzewdQ",
        md5: "5809e5fda81eed34bad9ca6eff414924",
        sha1: "6c95f0d9210e88028074d4baaeefc3d6c830a9a3",
        sha256: "f92fc585c017d093b03dba898162613380f137f934637c5bf9050fe68c103c54",
        registered: 1180746503,
        dob: 1028583070,
        phone: "041-252-0953",
        cell: "081-567-1935",
        PPS: "2470896T",
        picture: picture
        )

		when: "the User does not pass the validation test"
		  user.save(flush:true)

		then: "the number of Users should be equals to 1"
			assertEquals 1, User.list().size()
    }

}
