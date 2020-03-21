import request from '@/utils/request'

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

export function fetchNotice(id) {
  return request({
    url: '/notice/detail',
    method: 'get',
    params: { id }
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
    method: 'post',
    data
  })
}
