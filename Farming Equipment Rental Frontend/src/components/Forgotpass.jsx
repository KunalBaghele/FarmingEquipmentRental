// PasswordReset.js

import axios from 'axios';
import React, { useState } from 'react';
import { toast } from 'react-toastify';
import { useHistory } from "react-router-dom";

function ForgotPassword() {
  const BASEURL = process.env.REACT_APP_BACKEND_URL
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [email, setEmail] = useState('');
  const [role, setRole] = useState();
  const history = useHistory();


  const handleSubmit = (e) => {
    e.preventDefault();
    if (password === "" || confirmPassword === "" || role === "") {
      toast.error("Please Fill required Field", { position: toast.POSITION.TOP_CENTER })
      return
    }
    // else {
    //  try {
    if (password === confirmPassword) {
      const userid = email;
      const pwd = password;
      let url = BASEURL + 'api/admin';
      if (role === "Customer") {

        url = BASEURL + 'api/customers';
        axios.patch(url, {
          userid, pwd, role
        }).then(res => {
          console.log(res.data);
          toast.success("Customer password changes successfull", { position: toast.POSITION.TOP_CENTER });
          history.push('/login')
        })

      } else {
        axios.patch(url, {
          userid, pwd, role
        }).then(res => {
          console.log(res.data);
          toast.success("Admin password changes successfull", { position: toast.POSITION.TOP_CENTER });
          history.push('/login')
        })
      }
      // } .catch(error => {
      //       console.log("error", error)
      //       toast.error("Something went wrong");
      //     })
    } else {
      toast.error("Password is not matching", { position: toast.POSITION.TOP_CENTER })
    }
  };

  return (
    <div>
      <div className="container" style={{ minHeight: '79vh' }}>
        <div className="row">
          <div className="col-sm-4 mx-auto text-center" style={{ boxShadow: '0 0 2px 1px white', marginTop: 20 }}>
            <h2>Reset Password</h2>
            <div className="card shadow" style={{ marginTop: 50 }}>
              <div className="card-body">
                <form onSubmit={handleSubmit} mt-2>
                  <div className="form-group">
                    <div className="input-group">
                      <div className="input-group-prepend">
                        <span className="input-group-text bg-success border-0 text-white">
                          <i className="fas fa-user-tie" />
                        </span>
                      </div>
                      <input type="text" placeholder="Enter Email Id" name="email" value={email} onChange={(e) => { setEmail(e.target.value) }} className="form-control" />
                    </div>
                  </div>
                  <div className="form-group">
                    <div className="input-group">
                      <div className="input-group-prepend">
                        <span className="input-group-text bg-success border-0 text-white">
                          <i className="fas fa-user-tie" />
                        </span>
                      </div>
                      <input type="password" placeholder="Enter Your Password" name="password" value={password} onChange={(e) => { setPassword(e.target.value) }} className="form-control" />
                    </div>
                  </div>
                  <div className="form-group">
                    <div className="input-group">
                      <div className="input-group-prepend">
                        <span className="input-group-text bg-success border-0 text-white">
                          <i className="fas fa-user-tie" />
                        </span>
                      </div>
                      <input type="password" placeholder="Enter Confirm Password" name="confirmPassword" value={confirmPassword} onChange={(e) => { setConfirmPassword(e.target.value) }} className="form-control" />
                    </div>
                  </div>
                  {/* {sessionStorage.getItem('role') == "Customer" ? ( */}
                    <div className="form-group">
                      <div className="input-group">
                        <div className="input-group-prepend">
                          <span className="input-group-text bg-success border-0 text-white">
                            <i className="fas fa-users" />
                          </span>
                        </div>
                        <select value={role} onChange={(e) => { setRole(e.target.value) }} required name="role" className="form-control">
                          <option value="">Select Role</option>
                          <option>Admin</option>
                          <option>Customer</option>
                        </select>
                      </div>
                    </div>
                  {/* ) : (<h1></h1>)} */}
                  <button type="submit" className="btn btn-success btn-block">Reset Password</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ForgotPassword;
