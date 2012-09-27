package meishi



import org.junit.*
import grails.test.mixin.*

@TestFor(HotAreaController)
@Mock(HotArea)
class HotAreaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/hotArea/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.hotAreaInstanceList.size() == 0
        assert model.hotAreaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.hotAreaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.hotAreaInstance != null
        assert view == '/hotArea/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/hotArea/show/1'
        assert controller.flash.message != null
        assert HotArea.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/hotArea/list'


        populateValidParams(params)
        def hotArea = new HotArea(params)

        assert hotArea.save() != null

        params.id = hotArea.id

        def model = controller.show()

        assert model.hotAreaInstance == hotArea
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/hotArea/list'


        populateValidParams(params)
        def hotArea = new HotArea(params)

        assert hotArea.save() != null

        params.id = hotArea.id

        def model = controller.edit()

        assert model.hotAreaInstance == hotArea
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/hotArea/list'

        response.reset()


        populateValidParams(params)
        def hotArea = new HotArea(params)

        assert hotArea.save() != null

        // test invalid parameters in update
        params.id = hotArea.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/hotArea/edit"
        assert model.hotAreaInstance != null

        hotArea.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/hotArea/show/$hotArea.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        hotArea.clearErrors()

        populateValidParams(params)
        params.id = hotArea.id
        params.version = -1
        controller.update()

        assert view == "/hotArea/edit"
        assert model.hotAreaInstance != null
        assert model.hotAreaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/hotArea/list'

        response.reset()

        populateValidParams(params)
        def hotArea = new HotArea(params)

        assert hotArea.save() != null
        assert HotArea.count() == 1

        params.id = hotArea.id

        controller.delete()

        assert HotArea.count() == 0
        assert HotArea.get(hotArea.id) == null
        assert response.redirectedUrl == '/hotArea/list'
    }
}
