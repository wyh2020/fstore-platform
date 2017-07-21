/**
 * Created with wyh.
 * Date: 2017/7/21
 * Time: 下午3:32
 */

import Vue from 'vue';
import Vuex from  'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({

  state:{
    count:11,
    countAlias:'count',

    todos: [
      { id: 1, text: '我是你大大爷', done: true },
      { id: 2, text: '我是你二大爷', done: false }
    ]
  },


  mutations:{
    increment(state){
      state.count++
    }
  },


  actions: {
    increment ({ commit }) {
      commit('increment')
    }
  },


  getters: {
    doneTodos: state => {
      return state.todos.filter(todo => todo.done)
    },

    notDoneTodos: state => {
      return state.todos.filter(todo => !todo.done)
    }
  }


})


export default store;

