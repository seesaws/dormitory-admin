import Vue from 'vue'
import Router from 'vue-router'
const _import = require('./_import_' + process.env.NODE_ENV)
// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/** note: submenu only apppear when children.length>=1
*   detail see  https://panjiachen.github.io/vue-element-admin-site/#/router-and-nav?id=sidebar
**/

/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirct in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    roles: ['admin','editor']     will control the page roles (you can set multiple roles)
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
    noCache: true                if true ,the page will no be cached(default is false)
  }
**/
export const constantRouterMap = [
  { path: '/login', component: _import('login/index'), hidden: true },
  { path: '/authredirect', component: _import('login/authredirect'), hidden: true },
  { path: '/404', component: _import('errorPage/404'), hidden: true },
  { path: '/401', component: _import('errorPage/401'), hidden: true },
  {
    path: '',
    component: Layout,
    redirect: 'index',
    children: [{
      path: 'index',
      component: _import('dashboard/index'),
      name: 'dashboard',
      meta: { title: '首页', icon: 'sound', noCache: true }
    }]
  }
]

export default new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

export const asyncRouterMap = [

  {
    path: '/system',
    component: Layout,
    meta: { perm: 'm:sys', title: '系统', icon: 'setting' },
    children: [
      {
        path: 'user_manage',
        name: 'user_manage',
        component: _import('_system/user/index'),
        meta: { perm: 'm:sys:user', title: '用户管理', icon: 'user', noCache: true }
      },
      {
        path: 'role_manage',
        name: 'role_manage',
        component: _import('_system/role/index'),
        meta: { perm: 'm:sys:role', title: '角色管理', icon: 'smile', noCache: true }
      },
      {
        hidden: true,
        path: 'role_manage/:roleId/assign_perm',
        name: 'role_manage_assign_perm',
        component: _import('_system/role/assign_perm'),
        meta: { hiddenTag: true, title: '角色授权' }
      },
      {
        path: 'perm_manage',
        name: 'perm_manage',
        component: _import('_system/perm/index'),
        meta: { perm: 'm:sys:perm', title: '权限管理', icon: 'lock', noCache: true }
      }

    ]
  },

  {
    path: '/info',
    component: Layout,
    meta: {
      perm: 'm:info',
      title: '信息',
      icon: 'info-circle'
    },
    children: [
      { path: 'myinfo', component: _import('menu/menu3_1'), name: 'menu3_1', meta: { perm: 'm:info:myinfo', title: '我的信息', icon: 'user', noCache: true }},
      { path: 'team', component: _import('menu/menu3_2'), name: 'menu3_2', meta: { perm: 'm:info:team', title: '宿舍信息', icon: 'team', noCache: true }},
      { path: 'school', component: _import('menu/menu3_3'), name: 'menu3_3', meta: { perm: 'm:info:school', title: '住校信息', icon: 'pushpin', noCache: true }}
    ]
  },

  {
    path: '/dormitory',
    component: Layout,
    meta: {
      perm: 'm:dormitory',
      title: '公寓',
      icon: 'home'
    },
    children: [
      { path: 'repair', component: _import('menu/menu4_1/a'), name: 'repair', meta: { perm: 'm:dormitory:repair', title: '报修中心', icon: 'setting', noCache: true }},
      { path: 'query', component: _import('menu/menu4_1/b'), name: 'query', meta: { perm: 'm:dormitory:query', title: '报修查询', icon: 'solution', noCache: true }},
      { path: 'manage', component: _import('menu/menu4_1/c'), name: 'manage', meta: { perm: 'm:dormitory:manage', title: '报修管理', icon: 'monitor', noCache: true }}

    ]
  },

  {
    path: '/notice_manage',
    component: Layout,
    meta: {
      perm: 'm:notice_manage',
      title: '公告',
      icon: 'notification'
    },
    children: [
      { path: 'create', component: _import('menu/notice/create'), name: 'notice_create', meta: { perm: 'm:notice_manage:create', title: '发布公告', icon: 'edit-square', noCache: true }},
      { path: 'edit/:nid(\\d+)', component: _import('menu/notice/edit'), name: 'notice_edit', meta: { perm: 'm:notice_manage:edit', title: '编辑公告', noCache: true, activeMenu: '/notice/list' }, hidden: true },
      { path: 'read/:nid(\\d+)', component: _import('menu/notice/read'), name: 'notice_read', meta: { perm: 'm:notice_manage:read', title: '查看公告', noCache: true, activeMenu: '/notice/list' }, hidden: true },
      { path: 'list', component: _import('menu/notice/list'), name: 'notice_list', meta: { perm: 'm:notice_manage:list', title: '公告列表', icon: 'unordered list', noCache: true }}
    ]
  },
  { path: '*', redirect: '/404', hidden: true }
]
