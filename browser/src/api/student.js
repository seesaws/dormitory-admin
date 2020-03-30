import request from '@/utils/request'

/**
 * 学生列表
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

export function fetchDetail() {
  return request({
    url: '/info/detail',
    method: 'get'
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

export function updateDetail(data) {
  return request({
    url: '/info/update',
    method: 'patch',
    data
  })
}
