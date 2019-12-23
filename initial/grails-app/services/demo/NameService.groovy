package demo

import groovy.transform.CompileStatic

@CompileStatic
class NameService {

    List<Name> findAllPersonNames() {
      Person.findAll().collect { Person person ->
            String firstName = null
            String lastName = null
            if ( person.name.contains('del ') ) {
                String[] arr = person.name.split('del ')
                if ( arr.length > 0 ) {
                    firstName = arr[0]
                    lastName = arr.getAt(0)
                }
            }
            String[] arr = person.name.split(' ')


            new Name(firstName: firstName, lastName: lastName)
      }
    }
}
