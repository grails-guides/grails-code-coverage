package demo

import grails.transaction.Transactional

@Transactional
class PersonGormService {

    @Transactional(readOnly = true)
    List<Person> findAllActive() {
        Person.where { active == true }.list()
    }
}