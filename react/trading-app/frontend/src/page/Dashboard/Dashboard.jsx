import React, { useState, useEffect } from 'react'
import TraderList from '../../component/TraderList/TraderList'
import Modal from 'react-modal';
import './Dashboard.scss'
import axios from 'axios';
import { createTraderUrl, deleteTraderUrl, tradersUrl } from '../../util/constants'

Modal.setAppElement('#root');


export default function Dashboard() {
  const [traders,setTraders] = useState (
    [
     {
     "key": "1",
     "id": 1,
     "firstName": "Mike",
     "lastName": "Spencer",
     "dob": "1990-01-01",
     "country": "Canada",
     "email": "mike@test.com",
     "amount": 0,
     "actions": "<button (click)='deleteTrader'>Delete Trader</button>"
     },
     {
     "key": "2",
     "id": 2,
     "firstName": "Hellen",
     "lastName": "Miller",
     "dob": "1990-01-01",
     "country": "Austria",
     "email": "hellen@test.com",
     "actions": "<button (click)='deleteTrader'>Delete Trader</button>",
     "amount": 0
     },
     {
     "key": "3",
     "id": 3,
     "firstName": "Jack",
     "lastName": "Reed",
     "dob": "1990-01-01",
     "country": "United Kingdom",
     "email": "jack@test.com",
     "actions": "<button (click)='deleteTrader'>Delete Trader</button>",
     "amount": 0
     }
   ]
   );
  const [state, setState] = useState ({
    firstname:"farnaz",
    lastname:"towhidi",
    dob: "12",
    email: "farnaz@gmail.com",
    country: "Iran"
  }
  )
  const [modalIsOpen, setModalIsOpen] = useState(false);

  useEffect(() => {
    console.log (traders)
  }, [traders]);


  function openModal() {
    setModalIsOpen(true)
  }

  function handleChange (e) {
    setState({ ...state, [e.target.name]: e.target.value });
  }

  function handleSubmit (e) {
    e.preventDefault();
    let newTrader = {
      key: "4",
      firstName: state.firstname,
      lastName: state.lastname,
      dob: state.dob,
      country: state.country,
      email: state.email,
      amount: 0,
    }
    setTraders ([...traders, newTrader])
    setModalIsOpen(false);
  }

  return (

    <div className="dashboard">

      <div className="dashboard-content">
        <div className="title">
            Dashboard
            <div className="add-trader-button">
              <button onClick={openModal} >Add Trader</button>
              <Modal  
                isOpen={modalIsOpen}       
              >
                <h2>Add New Trader</h2>
                  <form>
                    <input type="text"
                    name="firstname"
                    placeholder="First Name"
                    value={state.firstname}
                    onChange= {handleChange} />

                    <input type="text"
                    name="lastname"
                    placeholder='Last Name'
                    value={state.lastname}
                    onChange= {handleChange} />

                    <input type="text"
                    name="email"
                    placeholder='Email'
                    value={state.email}
                    onChange= {handleChange} /> 

                    <input type="text"
                    name="dob"
                    placeholder='Date of Birth'
                    value={state.dob}
                    onChange= {handleChange} />

                    <input type="text"
                    name="country"
                    placeholder='country'
                    value={state.country}
                    onChange= {handleChange} />

                    <button type='submit' value="Submit" onClick={handleSubmit}>Add trader</button>
                  </form>          
                    
              </Modal>                     
            </div>
            <TraderList traders={traders} setTraders={setTraders}></TraderList>  
              
        </div>
      </div>
    </div>






  )
}
