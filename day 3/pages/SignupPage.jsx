
// import { useState } from 'react'
import '../assets/css/SignupPage.css'
import { Link } from 'react-router-dom'
const SignupPage = () => {
  

  return (
    <>
      <div
        className="wrapper"
        style={{
          backgroundImage:
            'url("https://images.unsplash.com/photo-1512386233331-f023884a92e8?q=80&w=1795&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")',
        }}
      >
        <div className="inner">
          <div className="image-holder">
            <img
              src="https://images.unsplash.com/photo-1562088287-bde35a1ea917?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8eW9nYXxlbnwwfDF8MHx8fDA%3D"
              alt=""
            />
          </div>
          <form action="">
            <h3>Registration Form</h3>
            <div className="form-group">
              <input
                type="text"
                placeholder="First Name"
                className="form-control"
              />
              <input
                type="text"
                placeholder="Last Name"
                className="form-control"
              />
            </div>
            <div className="form-wrapper">
              <input
                type="text"
                placeholder="Username"
                className="form-control"
              />
            </div>
            <div className="form-wrapper">
              <input
                type="text"
                placeholder="Email Address"
                className="form-control"
              />
            </div>
            <div className="form-wrapper">
              <select name="" id="" className="form-control">
                <option value="" disabled="" selected="">
                  Gender
                </option>
                <option value="male">Male</option>
                <option value="femal">Female</option>
                <option value="other">Other</option>
              </select>
            </div>
            <div className="form-wrapper">
              <input
                type="password"
                placeholder="Password"
                className="form-control"
              />
            </div>
            <div className="form-wrapper">
              <input
                type="password"
                placeholder="Confirm Password"
                className="form-control"
              />
            </div>
            <Link to='/home'>
              <button>Register</button>
            </Link>
          </form>
        </div>
      </div>
    </>
  )
}

export default SignupPage
