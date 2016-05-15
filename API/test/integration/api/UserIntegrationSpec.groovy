package api

import grails.converters.JSON
import grails.test.spock.IntegrationSpec
import groovy.json.JsonSlurper

class UserIntegrationSpec extends IntegrationSpec {

	def setup() {
		User.findAll().each { it.delete() } // deletes all user objects in the testing db
	}

	def cleanup() {
		User.findAll().each { it.delete() } // deletes all user objects in the testing db
	}

	void "Test creation of valid user via API"() {
    given: "the API"
    def userController = new UserController()

		when: "we send valid user data to the create method"
		userController.request.json = '{"user":{"gender":"female","name":{"title":"miss","first":"alison","last":"reid"},"location":{"street":"1097 the avenue","city":"Newbridge","state":"ohio","zip":28782},"email":"alison.reid@example.com","username":"tinywolf709","password":"rockon","salt":"lypI10wj","md5":"bbdd6140e188e3bf68ae7ae67345df65","sha1":"4572d25c99aa65bbf0368168f65d9770b7cacfe6","sha256":"ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb","registered":1237176893,"dob":932871968,"phone":"031-541-9181","cell":"081-647-4650","PPS":"3302243T","picture":{"large":"https://randomuser.me/api/portraits/women/60.jpg","medium":"https://randomuser.me/api/portraits/med/women/60.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/60.jpg"}}}'
		userController.create()
    	def response = userController.response.json

		then: "a new user should be created"
		response.status == "200"
		response.links.size == 3
    assertEquals 1, User.list().size()
	}


  void "Test creation of invalid user via API"() {
    given: "the API"
    def userController = new UserController()

		when: "we send valid user data to the create method"
		userController.request.json = '{"user":{"gender":"man","name":{"title":"miss","first":"alison","last":"reid"},"location":{"street":"1097 the avenue","city":"Newbridge","state":"ohio","zip":28782},"email":"alison.reid@example.com","username":"tinywolf709","password":"rockon","salt":"lypI10wj","md5":"bbdd6140e188e3bf68ae7ae67345df65","sha1":"4572d25c99aa65bbf0368168f65d9770b7cacfe6","sha256":"ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb","registered":1237176893,"dob":932871968,"phone":"031-541-9181","cell":"081-647-4650","PPS":"3302243T","picture":{"large":"https://randomuser.me/api/portraits/women/60.jpg","medium":"https://randomuser.me/api/portraits/med/women/60.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/60.jpg"}}}'
		userController.create()
    	def response = userController.response.json

		then: "a new user should be created"
		response.status == "405"
		response.links.size == 3
    assertEquals 0, User.list().size()
	}


  void "Test deletion of user via API"() {
    given: "the API"
    def userController = new UserController()

		when: "we send valid user data to the create method"
		userController.request.json = '{"user":{"gender":"female","name":{"title":"miss","first":"alison","last":"reid"},"location":{"street":"1097 the avenue","city":"Newbridge","state":"ohio","zip":28782},"email":"alison.reid@example.com","username":"tinywolf709","password":"rockon","salt":"lypI10wj","md5":"bbdd6140e188e3bf68ae7ae67345df65","sha1":"4572d25c99aa65bbf0368168f65d9770b7cacfe6","sha256":"ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb","registered":1237176893,"dob":932871968,"phone":"031-541-9181","cell":"081-647-4650","PPS":"3302243T","picture":{"large":"https://randomuser.me/api/portraits/women/60.jpg","medium":"https://randomuser.me/api/portraits/med/women/60.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/60.jpg"}}}'
		userController.create()

		then: "a new user should be created"
		def response = userController.response.json
		response.status == "200"
		response.links.size == 2
    assertEquals 1, User.list().size()

    when: "we delete the created user"
    userController.params.id = "alison.reid@example.com"
    userController.delete()

    then: "the database should have 0 records"
    assertEquals 0, User.list().size()
	}


  void "Test updating of user via API"() {
    given: "the API"
    def userController = new UserController()

		when: "we send valid user data to the update method"
		userController.request.json = '{"user":{"gender":"female","name":{"title":"miss","first":"alison","last":"reid"},"location":{"street":"1097 the avenue","city":"Newbridge","state":"ohio","zip":28782},"email":"alison.reid@example.com","username":"tinywolf709","password":"rockon","salt":"lypI10wj","md5":"bbdd6140e188e3bf68ae7ae67345df65","sha1":"4572d25c99aa65bbf0368168f65d9770b7cacfe6","sha256":"ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb","registered":1237176893,"dob":932871968,"phone":"031-541-9181","cell":"081-647-4650","PPS":"3302243T","picture":{"large":"https://randomuser.me/api/portraits/women/60.jpg","medium":"https://randomuser.me/api/portraits/med/women/60.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/60.jpg"}}}'
		userController.create()

		then: "a new user should be created"
		def response = userController.response.json
		response.status == "200"
		response.links.size == 2
    assertEquals 1, User.list().size()

    when: "we update the created user"
    userController.params.id = "alison.reid@example.com"
    userController.request.json = '{"user":{"gender":"female","name":{"title":"MS","first":"ALICE","last":"DOYLE"},"location":{"street":"1097 the avenue","city":"Newbridge","state":"ohio","zip":28782},"email":"alison.reid@example.com","username":"tinywolf709","password":"rockon","salt":"lypI10wj","md5":"bbdd6140e188e3bf68ae7ae67345df65","sha1":"4572d25c99aa65bbf0368168f65d9770b7cacfe6","sha256":"ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb","registered":1237176893,"dob":932871968,"phone":"031-541-9181","cell":"081-647-4650","PPS":"3302243T","picture":{"large":"https://randomuser.me/api/portraits/women/60.jpg","medium":"https://randomuser.me/api/portraits/med/women/60.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/60.jpg"}}}'
    userController.update()

    then: "the database should still have 1 record"
    assertEquals 1, User.list().size()
    response.status == "200"
		response.links.size == 2
	}


  void "Test updating of user with invalid via API"() {
    given: "the API"
    def userController = new UserController()

		when: "we send valid user data to the update method"
		userController.request.json = '{"user":{"gender":"female","name":{"title":"miss","first":"alison","last":"reid"},"location":{"street":"1097 the avenue","city":"Newbridge","state":"ohio","zip":28782},"email":"alison.reid@example.com","username":"tinywolf709","password":"rockon","salt":"lypI10wj","md5":"bbdd6140e188e3bf68ae7ae67345df65","sha1":"4572d25c99aa65bbf0368168f65d9770b7cacfe6","sha256":"ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb","registered":1237176893,"dob":932871968,"phone":"031-541-9181","cell":"081-647-4650","PPS":"3302243T","picture":{"large":"https://randomuser.me/api/portraits/women/60.jpg","medium":"https://randomuser.me/api/portraits/med/women/60.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/60.jpg"}}}'
		userController.create()

		then: "a new user should be created"
		def response = userController.response.json
		response.status == "200"
		response.links.size == 2
    assertEquals 1, User.list().size()

    when: "we update the created user using invalid data"
    userController.params.id = "alison.reid@example.com"
    userController.request.json = '{"user":{"gender":"WOMAN","name":{"title":"MS","first":"ALICE","last":"DOYLE"},"location":{"street":"1097 the avenue","city":"Newbridge","state":"ohio","zip":28782},"email":"alison.reid@example.com","username":"tinywolf709","password":"rockon","salt":"lypI10wj","md5":"bbdd6140e188e3bf68ae7ae67345df65","sha1":"4572d25c99aa65bbf0368168f65d9770b7cacfe6","sha256":"ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb","registered":1237176893,"dob":932871968,"phone":"031-541-9181","cell":"081-647-4650","PPS":"3302243T","picture":{"large":"https://randomuser.me/api/portraits/women/60.jpg","medium":"https://randomuser.me/api/portraits/med/women/60.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/60.jpg"}}}'
    userController.update()

    then: "the database should still have 1 record with a failure return code"
    assertEquals 1, User.list().size()
    response.status == "405"
		response.links.size == 2
	}


  void "Test listing of users via API"() {
    given: "the API"
    def userController = new UserController()

		when: "we send valid user data to the create method"
		userController.request.json = '{"user":{"gender":"female","name":{"title":"miss","first":"alison","last":"reid"},"location":{"street":"1097 the avenue","city":"Newbridge","state":"ohio","zip":28782},"email":"alison.reid@example.com","username":"tinywolf709","password":"rockon","salt":"lypI10wj","md5":"bbdd6140e188e3bf68ae7ae67345df65","sha1":"4572d25c99aa65bbf0368168f65d9770b7cacfe6","sha256":"ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb","registered":1237176893,"dob":932871968,"phone":"031-541-9181","cell":"081-647-4650","PPS":"3302243T","picture":{"large":"https://randomuser.me/api/portraits/women/60.jpg","medium":"https://randomuser.me/api/portraits/med/women/60.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/60.jpg"}}}'
		userController.create()

		then: "a new user should be created"
    def response = userController.response.json
		response.status == "200"
		response.links.size == 3
    assertEquals 1, User.list().size()

    when: "we create another user"
		userController.request.json = '{"user":{"gender":"female","name":{"title":"miss","first":"sarah","last":"smith"},"location":{"street":"1097 the avenue","city":"Newbridge","state":"ohio","zip":28782},"email":"sarah.smith@example.com","username":"sarah45","password":"rockon","salt":"lypI10wj","md5":"bbdd6140e188e3bf68ae7ae67345df65","sha1":"4572d25c99aa65bbf0368168f65d9770b7cacfe6","sha256":"ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb","registered":1237176893,"dob":932871968,"phone":"031-541-9181","cell":"081-647-4650","PPS":"3302243T","picture":{"large":"https://randomuser.me/api/portraits/women/60.jpg","medium":"https://randomuser.me/api/portraits/med/women/60.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/60.jpg"}}}'
		userController.create()

		then: "another user should be created"
    def response2 = userController.response.json
		response2.status == "200"
		response2.links.size == 3
    assertEquals 2, User.list().size()

    when: "the API list method is called"
    userController.index()

    then: "the number of users returned is equal to 2"
    response2.status == "200"
		response2.links.users == 2

	}

}
