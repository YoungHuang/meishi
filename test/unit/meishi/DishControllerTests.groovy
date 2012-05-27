package meishi



import org.junit.*
import grails.test.mixin.*

@TestFor(DishController)
@Mock(Dish)
class DishControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/dish/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.dishInstanceList.size() == 0
        assert model.dishInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.dishInstance != null
    }

    void testSave() {
        controller.save()

        assert model.dishInstance != null
        assert view == '/dish/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/dish/show/1'
        assert controller.flash.message != null
        assert Dish.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/dish/list'


        populateValidParams(params)
        def dish = new Dish(params)

        assert dish.save() != null

        params.id = dish.id

        def model = controller.show()

        assert model.dishInstance == dish
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/dish/list'


        populateValidParams(params)
        def dish = new Dish(params)

        assert dish.save() != null

        params.id = dish.id

        def model = controller.edit()

        assert model.dishInstance == dish
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/dish/list'

        response.reset()


        populateValidParams(params)
        def dish = new Dish(params)

        assert dish.save() != null

        // test invalid parameters in update
        params.id = dish.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/dish/edit"
        assert model.dishInstance != null

        dish.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/dish/show/$dish.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        dish.clearErrors()

        populateValidParams(params)
        params.id = dish.id
        params.version = -1
        controller.update()

        assert view == "/dish/edit"
        assert model.dishInstance != null
        assert model.dishInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/dish/list'

        response.reset()

        populateValidParams(params)
        def dish = new Dish(params)

        assert dish.save() != null
        assert Dish.count() == 1

        params.id = dish.id

        controller.delete()

        assert Dish.count() == 0
        assert Dish.get(dish.id) == null
        assert response.redirectedUrl == '/dish/list'
    }
}
