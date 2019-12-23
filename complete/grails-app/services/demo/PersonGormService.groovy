package demo

import grails.gorm.transactions.Transactional

@Transactional
class PersonGormService {

    @Transactional(readOnly = true)
    List<Person> findAllActive() {
        Person.where { active == true }.list()
    }
}