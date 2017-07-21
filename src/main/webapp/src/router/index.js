/**
 * Created with wyh.
 * Date: 2017/7/7
 * Time: 上午10:20
 */
import Vue from 'vue';
import Router from 'vue-router';


/**
 * webpack1 用法
 */
// const Login = resolve => require(['../views/login/index.vue'], resolve)
// const Home = resolve => require(['../views/home/index.vue'], resolve)

/**
 * webpack2.4.0+ 用法
 */
const Demo = () => import(/* webpackChunkName: "demo" */'../views/demo/index.vue');
const Home = () => import(/* webpackChunkName: "home" */'../views/home/index.vue');

const VuexState = () => import(/* webpackChunkName: "vuexState" */'../views/vuex-state/index.vue');
const VuexMapState = () => import(/* webpackChunkName: "vuexMapState" */'../views/vuex-mapState/index.vue');
const VuexGetters = () => import(/* webpackChunkName: "vuexGetters" */'../views/vuex-getters/index.vue');
const VuexMapGetters = () => import(/* webpackChunkName: "vuexMapGetters" */'../views/vuex-mapGetters/index.vue');
const VuexMutations = () => import(/* webpackChunkName: "vuexMutations" */'../views/vuex-mutations/index.vue');
const VuexAction = () => import(/* webpackChunkName: "vuexAction" */'../views/vuex-action/index.vue');




Vue.use(Router);


export default new Router({
  scrollbarBehavior: () => ({y: 0}),
  routes: [
    {path: '/', component: Home, hidden: true, meta: [],},
    {path: '/demo', component: Demo, hidden: true, meta: ["测试路由","Demo页面"],},
    {path: '/home', component: Home, hidden: true, meta: ['测试路由', 'Home页面'],},

    {path: '/vuex-state', component: VuexState, hidden: true, meta: ['测试路由', 'VuexState页面'],},
    {path: '/vuex-mapState', component: VuexMapState, hidden: true, meta: ['测试路由', 'VueMapState页面'],},
    {path: '/vuex-getters', component: VuexGetters, hidden: true, meta: ['测试路由', 'VuexGetters页面'],},
    {path: '/vuex-mapGetters', component: VuexMapGetters, hidden: true, meta: ['测试路由', 'VuexMapGetters页面'],},
    {path: '/vuex-mutations', component: VuexMutations, hidden: true, meta: ['测试路由', 'vuexMutations页面'],},
    {path: '/vuex-action', component: VuexAction, hidden: true, meta: ['测试路由', 'vuexAction页面'],},
  ]
});



