import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
// import 'element-ui/lib/theme-default/index.css'

Vue.use(ElementUI);

new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  render : (h)=>h(App)
}).$mount('#app')
