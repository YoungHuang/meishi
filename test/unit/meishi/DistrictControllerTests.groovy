package meishi



import org.junit.*
import grails.test.mixin.*

@TestFor(DistrictController)
@Mock(District)
class DistrictControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/district/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.districtInstanceList.size() == 0
        assert model.districtInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.districtInstance != null
    }

    void testSave() {
        controller.save()

        assert model.districtInstance != null
        assert view == '/district/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/district/show/1'
        assert controller.flash.message != null
        assert District.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/district/list'


        populateValidParams(params)
        def district = new District(params)

        assert district.save() != null

        params.id = district.id

        def model = controller.show()

        assert model.districtInstance == district
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/district/list'


        populateValidParams(params)
        def district = new District(params)

        assert district.save() != null

        params.id = district.id

        def model = controller.edit()

        assert model.districtInstance == district
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/district/list'

        response.reset()


        populateValidParams(params)
        def district = new District(params)

        assert district.save() != null

        // test invalid parameters in update
        params.id = district.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/district/edit"
        assert model.districtInstance != null

        district.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/district/show/$district.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        district.clearErrors()

        populateValidParams(params)
        params.id = district.id
        params.version = -1
        controller.update()

        assert view == "/district/edit"
        assert model.districtInstance != null
        assert model.districtInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/district/list'

        response.reset()

        populateValidParams(params)
        def district = new District(params)

        assert district.save() != null
        assert District.count() == 1

        params.id = district.id

        controller.delete()

        assert District.count() == 0
        assert District.get(district.id) == null
        assert response.redirectedUrl == '/district/list'
    }
}
