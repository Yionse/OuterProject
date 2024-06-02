// store/index.js
import { createStore } from "vuex";

const store = createStore({
  state() {
    return {
      users: [],
      currentUser: {},
    };
  },
  mutations: {
    login(state, { userName, password }) {
      const cur = state.users.find((item) => {
        if (item.userName === userName && item.password === password) {
          return item;
        } else {
          return false;
        }
      });
      if (cur?.userName) {
        // 登录成功
        state.currentUser = cur;
      }
    },
    register(state, param) {
      state.users.push(param);
    },
  },
});

export default store;
