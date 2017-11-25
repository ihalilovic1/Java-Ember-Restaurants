'use strict';

define('restaurants/tests/app.lint-test', [], function () {
  'use strict';

  QUnit.module('ESLint | app');

  QUnit.test('app.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'app.js should pass ESLint\n\n');
  });

  QUnit.test('components/dollar-rating.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'components/dollar-rating.js should pass ESLint\n\n');
  });

  QUnit.test('components/footer-component.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'components/footer-component.js should pass ESLint\n\n');
  });

  QUnit.test('components/header-component.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'components/header-component.js should pass ESLint\n\n24:43 - \'data\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('components/rate-component.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'components/rate-component.js should pass ESLint\n\n');
  });

  QUnit.test('components/restaurant-tile.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'components/restaurant-tile.js should pass ESLint\n\n');
  });

  QUnit.test('components/search-bar.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'components/search-bar.js should pass ESLint\n\n');
  });

  QUnit.test('components/star-rating.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'components/star-rating.js should pass ESLint\n\n');
  });

  QUnit.test('controllers/complete-reservation.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'controllers/complete-reservation.js should pass ESLint\n\n');
  });

  QUnit.test('controllers/login.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'controllers/login.js should pass ESLint\n\n');
  });

  QUnit.test('controllers/register.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'controllers/register.js should pass ESLint\n\n');
  });

  QUnit.test('controllers/restaurant.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'controllers/restaurant.js should pass ESLint\n\n');
  });

  QUnit.test('controllers/restaurants.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'controllers/restaurants.js should pass ESLint\n\n');
  });

  QUnit.test('helpers/adition-helper.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/adition-helper.js should pass ESLint\n\n');
  });

  QUnit.test('helpers/current-date.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'helpers/current-date.js should pass ESLint\n\n3:29 - \'params\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('helpers/equals-helper.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/equals-helper.js should pass ESLint\n\n');
  });

  QUnit.test('helpers/format-date.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/format-date.js should pass ESLint\n\n');
  });

  QUnit.test('helpers/format-time.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/format-time.js should pass ESLint\n\n');
  });

  QUnit.test('resolver.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'resolver.js should pass ESLint\n\n');
  });

  QUnit.test('router.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'router.js should pass ESLint\n\n');
  });

  QUnit.test('routes/complete-reservation.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/complete-reservation.js should pass ESLint\n\n41:40 - \'error\' is defined but never used. (no-unused-vars)\n48:40 - \'error\' is defined but never used. (no-unused-vars)\n56:40 - \'error\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('routes/index.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/index.js should pass ESLint\n\n20:40 - \'error\' is defined but never used. (no-unused-vars)\n27:48 - \'error\' is defined but never used. (no-unused-vars)\n34:48 - \'error\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('routes/login.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/login.js should pass ESLint\n\n17:23 - \'data\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('routes/register.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/register.js should pass ESLint\n\n26:23 - \'data\' is defined but never used. (no-unused-vars)\n30:24 - \'error\' is defined but never used. (no-unused-vars)\n44:44 - \'error\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('routes/restaurant.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/restaurant.js should pass ESLint\n\n61:23 - \'data\' is defined but never used. (no-unused-vars)\n64:24 - \'error\' is defined but never used. (no-unused-vars)\n82:24 - \'error\' is defined but never used. (no-unused-vars)\n107:40 - \'error\' is defined but never used. (no-unused-vars)\n114:44 - \'error\' is defined but never used. (no-unused-vars)\n122:44 - \'error\' is defined but never used. (no-unused-vars)\n129:44 - \'error\' is defined but never used. (no-unused-vars)\n136:40 - \'error\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('routes/restaurants.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/restaurants.js should pass ESLint\n\n48:20 - \'error\' is defined but never used. (no-unused-vars)\n59:40 - \'error\' is defined but never used. (no-unused-vars)\n67:44 - \'error\' is defined but never used. (no-unused-vars)\n77:44 - \'error\' is defined but never used. (no-unused-vars)\n85:44 - \'error\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('services/ajax.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'services/ajax.js should pass ESLint\n\n');
  });

  QUnit.test('services/reservation-service.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'services/reservation-service.js should pass ESLint\n\n7:20 - \'Promise\' is not defined. (no-undef)\n29:20 - \'Promise\' is not defined. (no-undef)\n51:20 - \'Promise\' is not defined. (no-undef)\n64:20 - \'Promise\' is not defined. (no-undef)\n82:20 - \'Promise\' is not defined. (no-undef)');
  });

  QUnit.test('services/restaurant-service.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'services/restaurant-service.js should pass ESLint\n\n7:20 - \'Promise\' is not defined. (no-undef)\n29:20 - \'Promise\' is not defined. (no-undef)\n42:20 - \'Promise\' is not defined. (no-undef)\n55:20 - \'Promise\' is not defined. (no-undef)\n74:20 - \'Promise\' is not defined. (no-undef)\n86:20 - \'Promise\' is not defined. (no-undef)\n106:20 - \'Promise\' is not defined. (no-undef)\n131:20 - \'Promise\' is not defined. (no-undef)');
  });

  QUnit.test('services/user-service.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'services/user-service.js should pass ESLint\n\n12:20 - \'Promise\' is not defined. (no-undef)\n27:20 - \'Promise\' is not defined. (no-undef)\n50:20 - \'Promise\' is not defined. (no-undef)\n78:20 - \'Promise\' is not defined. (no-undef)');
  });
});
define('restaurants/tests/helpers/destroy-app', ['exports'], function (exports) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.default = destroyApp;
  function destroyApp(application) {
    Ember.run(application, 'destroy');
  }
});
define('restaurants/tests/helpers/module-for-acceptance', ['exports', 'qunit', 'restaurants/tests/helpers/start-app', 'restaurants/tests/helpers/destroy-app'], function (exports, _qunit, _startApp, _destroyApp) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });

  exports.default = function (name) {
    var options = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : {};

    (0, _qunit.module)(name, {
      beforeEach: function beforeEach() {
        this.application = (0, _startApp.default)();

        if (options.beforeEach) {
          return options.beforeEach.apply(this, arguments);
        }
      },
      afterEach: function afterEach() {
        var _this = this;

        var afterEach = options.afterEach && options.afterEach.apply(this, arguments);
        return resolve(afterEach).then(function () {
          return (0, _destroyApp.default)(_this.application);
        });
      }
    });
  };

  var resolve = Ember.RSVP.resolve;
});
define('restaurants/tests/helpers/resolver', ['exports', 'restaurants/resolver', 'restaurants/config/environment'], function (exports, _resolver, _environment) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });


  var resolver = _resolver.default.create();

  resolver.namespace = {
    modulePrefix: _environment.default.modulePrefix,
    podModulePrefix: _environment.default.podModulePrefix
  };

  exports.default = resolver;
});
define('restaurants/tests/helpers/start-app', ['exports', 'restaurants/app', 'restaurants/config/environment'], function (exports, _app, _environment) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.default = startApp;
  function startApp(attrs) {
    var attributes = Ember.merge({}, _environment.default.APP);
    attributes = Ember.merge(attributes, attrs); // use defaults, but you can override;

    return Ember.run(function () {
      var application = _app.default.create(attributes);
      application.setupForTesting();
      application.injectTestHelpers();
      return application;
    });
  }
});
define('restaurants/tests/integration/components/dollar-rating-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('dollar-rating', 'Integration | Component | dollar rating', {
    integration: true
  });

  (0, _emberQunit.test)('it renders', function (assert) {
    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.on('myAction', function(val) { ... });

    this.render(Ember.HTMLBars.template({
      "id": "+9xdseja",
      "block": "{\"symbols\":[],\"statements\":[[1,[18,\"dollar-rating\"],false]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '');

    // Template block usage:
    this.render(Ember.HTMLBars.template({
      "id": "7xlQGgWh",
      "block": "{\"symbols\":[],\"statements\":[[0,\"\\n\"],[4,\"dollar-rating\",null,null,{\"statements\":[[0,\"      template block text\\n\"]],\"parameters\":[]},null],[0,\"  \"]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), 'template block text');
  });
});
define('restaurants/tests/integration/components/footer-component-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('footer-component', 'Integration | Component | footer component', {
    integration: true
  });

  (0, _emberQunit.test)('it renders', function (assert) {
    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.on('myAction', function(val) { ... });

    this.render(Ember.HTMLBars.template({
      "id": "w/Y6Wwu7",
      "block": "{\"symbols\":[],\"statements\":[[1,[18,\"footer-component\"],false]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '');

    // Template block usage:
    this.render(Ember.HTMLBars.template({
      "id": "XCyOfH/2",
      "block": "{\"symbols\":[],\"statements\":[[0,\"\\n\"],[4,\"footer-component\",null,null,{\"statements\":[[0,\"      template block text\\n\"]],\"parameters\":[]},null],[0,\"  \"]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), 'template block text');
  });
});
define('restaurants/tests/integration/components/header-component-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('header-component', 'Integration | Component | header component', {
    integration: true
  });

  (0, _emberQunit.test)('it renders', function (assert) {
    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.on('myAction', function(val) { ... });

    this.render(Ember.HTMLBars.template({
      "id": "PmCEARoP",
      "block": "{\"symbols\":[],\"statements\":[[1,[18,\"header-component\"],false]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '');

    // Template block usage:
    this.render(Ember.HTMLBars.template({
      "id": "Ue2qwXxb",
      "block": "{\"symbols\":[],\"statements\":[[0,\"\\n\"],[4,\"header-component\",null,null,{\"statements\":[[0,\"      template block text\\n\"]],\"parameters\":[]},null],[0,\"  \"]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), 'template block text');
  });
});
define('restaurants/tests/integration/components/rate-component-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('rate-component', 'Integration | Component | rate component', {
    integration: true
  });

  (0, _emberQunit.test)('it renders', function (assert) {
    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.on('myAction', function(val) { ... });

    this.render(Ember.HTMLBars.template({
      "id": "hUPuf59W",
      "block": "{\"symbols\":[],\"statements\":[[1,[18,\"rate-component\"],false]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '');

    // Template block usage:
    this.render(Ember.HTMLBars.template({
      "id": "htG9kJbo",
      "block": "{\"symbols\":[],\"statements\":[[0,\"\\n\"],[4,\"rate-component\",null,null,{\"statements\":[[0,\"      template block text\\n\"]],\"parameters\":[]},null],[0,\"  \"]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), 'template block text');
  });
});
define('restaurants/tests/integration/components/restaurant-tile-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('restaurant-tile', 'Integration | Component | restaurant tile', {
    integration: true
  });

  (0, _emberQunit.test)('it renders', function (assert) {
    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.on('myAction', function(val) { ... });

    this.render(Ember.HTMLBars.template({
      "id": "D3E9pMmK",
      "block": "{\"symbols\":[],\"statements\":[[1,[18,\"restaurant-tile\"],false]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '');

    // Template block usage:
    this.render(Ember.HTMLBars.template({
      "id": "ViQvWpKc",
      "block": "{\"symbols\":[],\"statements\":[[0,\"\\n\"],[4,\"restaurant-tile\",null,null,{\"statements\":[[0,\"      template block text\\n\"]],\"parameters\":[]},null],[0,\"  \"]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), 'template block text');
  });
});
define('restaurants/tests/integration/components/search-bar-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('search-bar', 'Integration | Component | search bar', {
    integration: true
  });

  (0, _emberQunit.test)('it renders', function (assert) {
    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.on('myAction', function(val) { ... });

    this.render(Ember.HTMLBars.template({
      "id": "tlJ6Y+u+",
      "block": "{\"symbols\":[],\"statements\":[[1,[18,\"search-bar\"],false]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '');

    // Template block usage:
    this.render(Ember.HTMLBars.template({
      "id": "tWxfyg0C",
      "block": "{\"symbols\":[],\"statements\":[[0,\"\\n\"],[4,\"search-bar\",null,null,{\"statements\":[[0,\"      template block text\\n\"]],\"parameters\":[]},null],[0,\"  \"]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), 'template block text');
  });
});
define('restaurants/tests/integration/components/star-rating-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('star-rating', 'Integration | Component | star rating', {
    integration: true
  });

  (0, _emberQunit.test)('it renders', function (assert) {
    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.on('myAction', function(val) { ... });

    this.render(Ember.HTMLBars.template({
      "id": "IROCw1eJ",
      "block": "{\"symbols\":[],\"statements\":[[1,[18,\"star-rating\"],false]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '');

    // Template block usage:
    this.render(Ember.HTMLBars.template({
      "id": "w9hziEKp",
      "block": "{\"symbols\":[],\"statements\":[[0,\"\\n\"],[4,\"star-rating\",null,null,{\"statements\":[[0,\"      template block text\\n\"]],\"parameters\":[]},null],[0,\"  \"]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), 'template block text');
  });
});
define('restaurants/tests/integration/helpers/adition-helper-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('adition-helper', 'helper:adition-helper', {
    integration: true
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it renders', function (assert) {
    this.set('inputValue', '1234');

    this.render(Ember.HTMLBars.template({
      "id": "d1uS5FSX",
      "block": "{\"symbols\":[],\"statements\":[[1,[25,\"adition-helper\",[[19,0,[\"inputValue\"]]],null],false]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '1234');
  });
});
define('restaurants/tests/integration/helpers/current-date-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('current-date', 'helper:current-date', {
    integration: true
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it renders', function (assert) {
    this.set('inputValue', '1234');

    this.render(Ember.HTMLBars.template({
      "id": "QF8Ce9M8",
      "block": "{\"symbols\":[],\"statements\":[[1,[25,\"current-date\",[[19,0,[\"inputValue\"]]],null],false]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '1234');
  });
});
define('restaurants/tests/integration/helpers/equals-helper-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('equals-helper', 'helper:equals-helper', {
    integration: true
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it renders', function (assert) {
    this.set('inputValue', '1234');

    this.render(Ember.HTMLBars.template({
      "id": "hWOoRlvG",
      "block": "{\"symbols\":[],\"statements\":[[1,[25,\"equals-helper\",[[19,0,[\"inputValue\"]]],null],false]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '1234');
  });
});
define('restaurants/tests/integration/helpers/format-date-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('format-date', 'helper:format-date', {
    integration: true
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it renders', function (assert) {
    this.set('inputValue', '1234');

    this.render(Ember.HTMLBars.template({
      "id": "wB2ngGss",
      "block": "{\"symbols\":[],\"statements\":[[1,[25,\"format-date\",[[19,0,[\"inputValue\"]]],null],false]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '1234');
  });
});
define('restaurants/tests/integration/helpers/format-time-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('format-time', 'helper:format-time', {
    integration: true
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it renders', function (assert) {
    this.set('inputValue', '1234');

    this.render(Ember.HTMLBars.template({
      "id": "xtSsa97L",
      "block": "{\"symbols\":[],\"statements\":[[1,[25,\"format-time\",[[19,0,[\"inputValue\"]]],null],false]],\"hasEval\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '1234');
  });
});
define('restaurants/tests/test-helper', ['restaurants/tests/helpers/resolver', 'ember-qunit', 'ember-cli-qunit'], function (_resolver, _emberQunit, _emberCliQunit) {
  'use strict';

  (0, _emberQunit.setResolver)(_resolver.default);
  (0, _emberCliQunit.start)();
});
define('restaurants/tests/tests.lint-test', [], function () {
  'use strict';

  QUnit.module('ESLint | tests');

  QUnit.test('helpers/destroy-app.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/destroy-app.js should pass ESLint\n\n');
  });

  QUnit.test('helpers/module-for-acceptance.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/module-for-acceptance.js should pass ESLint\n\n');
  });

  QUnit.test('helpers/resolver.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/resolver.js should pass ESLint\n\n');
  });

  QUnit.test('helpers/start-app.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/start-app.js should pass ESLint\n\n');
  });

  QUnit.test('integration/components/dollar-rating-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/dollar-rating-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/components/footer-component-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/footer-component-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/components/header-component-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/header-component-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/components/rate-component-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/rate-component-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/components/restaurant-tile-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/restaurant-tile-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/components/search-bar-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/search-bar-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/components/star-rating-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/star-rating-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/helpers/adition-helper-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/helpers/adition-helper-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/helpers/current-date-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/helpers/current-date-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/helpers/equals-helper-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/helpers/equals-helper-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/helpers/format-date-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/helpers/format-date-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/helpers/format-time-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/helpers/format-time-test.js should pass ESLint\n\n');
  });

  QUnit.test('test-helper.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'test-helper.js should pass ESLint\n\n');
  });

  QUnit.test('unit/adapters/user-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/adapters/user-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/controllers/complete-reservation-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/controllers/complete-reservation-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/controllers/login-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/controllers/login-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/controllers/register-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/controllers/register-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/controllers/restaurant-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/controllers/restaurant-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/controllers/restaurants-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/controllers/restaurants-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/models/user-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/models/user-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/complete-reservation-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/complete-reservation-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/index-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/index-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/login-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/login-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/register-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/register-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/restaurant-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/restaurant-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/restaurants-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/restaurants-test.js should pass ESLint\n\n');
  });
});
define('restaurants/tests/unit/adapters/user-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('adapter:user', 'Unit | Adapter | user', {
    // Specify the other units that are required for this test.
    // needs: ['serializer:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var adapter = this.subject();
    assert.ok(adapter);
  });
});
define('restaurants/tests/unit/controllers/complete-reservation-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('controller:complete-reservation', 'Unit | Controller | complete reservation', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var controller = this.subject();
    assert.ok(controller);
  });
});
define('restaurants/tests/unit/controllers/login-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('controller:login', 'Unit | Controller | login', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var controller = this.subject();
    assert.ok(controller);
  });
});
define('restaurants/tests/unit/controllers/register-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('controller:register', 'Unit | Controller | register', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var controller = this.subject();
    assert.ok(controller);
  });
});
define('restaurants/tests/unit/controllers/restaurant-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('controller:restaurant', 'Unit | Controller | restaurant', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var controller = this.subject();
    assert.ok(controller);
  });
});
define('restaurants/tests/unit/controllers/restaurants-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('controller:restaurants', 'Unit | Controller | restaurants', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var controller = this.subject();
    assert.ok(controller);
  });
});
define('restaurants/tests/unit/models/user-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForModel)('user', 'Unit | Model | user', {
    // Specify the other units that are required for this test.
    needs: []
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var model = this.subject();
    // let store = this.store();
    assert.ok(!!model);
  });
});
define('restaurants/tests/unit/routes/complete-reservation-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:complete-reservation', 'Unit | Route | complete reservation', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('restaurants/tests/unit/routes/index-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:index', 'Unit | Route | index', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('restaurants/tests/unit/routes/login-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:login', 'Unit | Route | login', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('restaurants/tests/unit/routes/register-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:register', 'Unit | Route | register', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('restaurants/tests/unit/routes/restaurant-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:restaurant', 'Unit | Route | restaurant', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('restaurants/tests/unit/routes/restaurants-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:restaurants', 'Unit | Route | restaurants', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
require('restaurants/tests/test-helper');
EmberENV.TESTS_FILE_LOADED = true;
//# sourceMappingURL=tests.map
