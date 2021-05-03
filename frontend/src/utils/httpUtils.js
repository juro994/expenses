export const getRequest = (path) => {
    return fetch(process.env.VUE_APP_API_URL + path, {
        headers: {
          Authorization: 'Bearer ' + localStorage.getItem('jwt')
        }
    })
}

export const postRequest = (path, body) => {
    return fetch(process.env.VUE_APP_API_URL + path, {
        method: 'POST',
        body: JSON.stringify(body),
        headers: {
          'Content-Type': 'application/json',
          Authorization: 'Bearer ' + localStorage.getItem('jwt')
        }
      })
}