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
const Demo = () => import('../views/demo/index.vue');
const Home = () => import('../views/home/index.vue');


Vue.use(Router);


export default new Router({
  scrollbarBehavior: () => ({y: 0}),
  routes: [
    {path: '/', component: Home, hidden: true, meta: [],},
    {path: '/demo', component: Demo, hidden: true, meta: ["测试路由","Demo页面"],},
    {path: '/home', component: Home, hidden: true, meta: ['测试路由', 'Home页面'],},
  ]
});



