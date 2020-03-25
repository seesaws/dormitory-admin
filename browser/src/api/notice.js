import request from '@/utils/request'

/**
 * 公告列表
 * @param {*} pageParam
 */
export function fetchList(pageParam) {
  return request({
    url: '/notice/query',
    method: 'post',
    data: {
      current: pageParam.current,
      size: pageParam.size
    }
  })
}

export function fetchNotice(nid) {
  return request({
    url: '/notice/detail',
    method: 'get',
    params: { nid }
  })
}

export function deleteNotice(data) {
  return request({
    url: '/notice/delete',
    method: 'delete',
    data
  })
}

export function createNotice(data) {
  return request({
    url: '/notice/create',
    method: 'post',
    data
  })
}

export function updateNotice(data) {
  return request({
    url: '/notice/update',
    method: 'patch',
    data
  })
}
