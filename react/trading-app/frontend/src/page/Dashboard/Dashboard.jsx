import React, { useState, useEffect } from 'react'
import TraderList from '../../component/TraderList/TraderList'
import Modal from 'react-modal';
import './Dashboard.scss'
import axios from 'axios';
import { createTraderUrl,tradersUrl } from '../../util/constants'
Modal.setAppElement('#root');


export default function Dashboard() {
  const [traders,setTraders] = useState (null);
  const [modalIsOpen, setModalIsOpen] = useState(false);
  const [state, setState] = useState ({
    firstname:"farnaz",
    lastname:"towhidi",
    dob: "12",
    email: "farnaz@gmail.com",
    country: "Iran"
  }
  )


  useEffect(() => {
  }, [traders]);


  useEffect (()=> {
    const fetchData = async () => {
      try {
        const response = await axios.get (tradersUrl)     
        if (response.status==200) setTraders(response.data);
      }
      catch (error) {
        console.error(error);
      }
    }
    fetchData();
  }, [])

  

  function openModal() {
    setModalIsOpen(true)
  }

  function handleChange (e) {
    setState({ ...state, [e.target.name]: e.target.value });
  }

  async function handleSubmit (e) {
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
    const newTraders = axios.post(createTraderUrl, newTrader)
    console.log (newTrader)
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
                isOpen={modalIsOpen} >
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
            { traders && <TraderList traders={traders} setTraders={setTraders}></TraderList>   }
              
        </div>
      </div>
    </div>
  )
}
