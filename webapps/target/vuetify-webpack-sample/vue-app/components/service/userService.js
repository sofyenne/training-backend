import axios from 'axios';
export default class userservice{
  async  getallusers(){
    return await axios.get('http://localhost:8080/portal/rest/api/user/');
  }
  async adduser(user){
    return await axios.post('http://localhost:8080/portal/rest/api/user/',user);
  }
  async delete(user){
    return await axios.delete(`http://localhost:8080/portal/rest/api/user/${user.id}`);
  }
}


