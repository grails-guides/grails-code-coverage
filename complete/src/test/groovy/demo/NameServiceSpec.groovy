package demo

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(NameService)
class NameServiceSpec extends Specification {

    def "findAllPersonNames differentiates between names containing the substring 'del'"() {

        given:
        service.personGormService = Stub(PersonGormService) {
            findAllActive() >> [
                    // new Person(name: 'Sergio del Amo', active: true), // <1>
                    new Person(name: 'Graeme Rocher', active: true),]
        }

        when:
        List<Name> names = service.findAllPersonNames()

        then:
        names.each { Name name ->
            assert [
                    new Name(firstName: 'Sergio del', lastName: 'Amo'),
                    new Name(firstName: 'Graeme', lastName: 'Rocher')
            ].contains(name)
        }
    }

}