// Environments
environments {
  // Development Environment
	development {
		grails{
			mongo{
				host ="localhost"
				port ="27017"
				databaseName ="RedHatProject"
			}
		}
	}

  // Test Environment
	test {
		grails{
			mongo{
				host ="localhost"
				port ="27017"
				databaseName ="RedHatProjectTest"
			}
		}
	}
}
