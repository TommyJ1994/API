package api

import grails.converters.JSON
import static org.springframework.http.HttpStatus.*

class UserController {

    /**
    *
    * @HttpMethod POST
    */
    def create() {
      def data = request.JSON.user

      def name = [title: data.name.title, first: data.name.first, last: data.name.last]
      def location = [street: data.location.street, city: data.location.city, state: data.location.state, zip: data.location.zip]
      def picture = [large: data.picture.large, medium: data.picture.medium, thumbnail: data.picture.thumbnail]

      def user = new User(gender: 'male',
  			name: name,
        location: location,
        email: data.email,
        username: data.username,
        password: data.password,
        salt: data.salt,
        md5: data.md5,
        sha1: data.sha1,
        sha256: data.sha256,
        registered: data.registered,
        dob: data.dob,
        phone: data.phone,
        cell: data.cell,
        PPS: data.PPS,
        picture: picture
        )

        user.validate()
    		if (user.hasErrors()) {
    			respond status: NOT_ACCEPTABLE
    			println user.errors
    			return
    		}

        user.save(flush:true)
        respond status: CREATED
    }

}
