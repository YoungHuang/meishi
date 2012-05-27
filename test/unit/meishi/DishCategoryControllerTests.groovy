package meishi



import org.junit.*
import grails.test.mixin.*

@TestFor(DishCategoryController)
@Mock(DishCategory)
class DishCategoryControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/dishCategory/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.dishCategoryInstanceList.size() == 0
        assert model.dishCategoryInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.dishCategoryInstance != null
    }

    void testSave() {
        controller.save()

        assert model.dishCategoryInstance != null
        assert view == '/dishCategory/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/dishCategory/show/1'
        assert controller.flash.message != null
        assert DishCategory.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/dishCategory/list'


        populateValidParams(params)
        def dishCategory = new DishCategory(params)

        assert dishCategory.save() != null

        params.id = dishCategory.id

        def model = controller.show()

        assert model.dishCategoryInstance == dishCategory
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/dishCategory/list'


        populateValidParams(params)
        def dishCategory = new DishCategory(params)

        assert dishCategory.save() != null

        params.id = dishCategory.id

        def model = controller.edit()

        assert model.dishCategoryInstance == dishCategory
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/dishCategory/list'

        response.reset()


        populateValidParams(params)
        def dishCategory = new DishCategory(params)

        assert dishCategory.save() != null

        // test invalid parameters in update
        params.id = dishCategory.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/dishCategory/edit"
        assert model.dishCategoryInstance != null

        dishCategory.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/dishCategory/show/$dishCategory.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        dishCategory.clearErrors()

        populateValidParams(params)
        params.id = dishCategory.id
        params.version = -1
        controller.update()

        assert view == "/dishCategory/edit"
        assert model.dishCategoryInstance != null
        assert model.dishCategoryInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/dishCategory/list'

        response.reset()

        populateValidParams(params)
        def dishCategory = new DishCategory(params)

        assert dishCategory.save() != null
        assert DishCategory.count() == 1

        params.id = dishCategory.id

        controller.delete()

        assert DishCategory.count() == 0
        assert DishCategory.get(dishCategory.id) == null
        assert response.redirectedUrl == '/dishCategory/list'
    }
}
