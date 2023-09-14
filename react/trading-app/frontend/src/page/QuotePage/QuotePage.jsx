import React, { useState, useEffect } from 'react'
import { Table } from 'antd';
import axios from 'axios';
import './QuotePage.scss';
import { dailyListQuotesUrl } from '../../util/constants'


export default function QuotePage() {
  const columns = [
    {
        title: 'Ticker',
        dataIndex: 'ticker',
        key: 'ticker',
    },
    {
        title: 'Last Price',
        dataIndex: 'lastPrice',
        key: 'lastPrice',
    },
    {
        title: 'Bid Price',
        dataIndex: 'bidPrice',
        key: 'bidPrice',
    },
    {
        title: 'Bid Size',
        dataIndex: 'bidSize',
        key: 'bidSize',
    },
    {
        title: 'Ask Price',
        dataIndex: 'askPrice',
        key: 'askPrice',
    },
    {
        title: 'Ask Size',
        dataIndex: 'askSize',
        key: 'askSize'
    },
];

  const [state,setState] = useState (null);
  const [dataSource, SetDataSource] = useState([
    {id:1,
    ticker:"FB",
    lastPrice: 10,
    bidPrice: 20, 
    bidSize: 40,
    askPrice: 50,
    askSize: 55
  }]);


  useEffect (() => {
    async function fetchData () {
      console.log ("test")
      const response = await axios.get (dailyListQuotesUrl)
      if (response.status==200) SetDataSource(response.data);
    }
    fetchData()
  },[])


  return (
    <div className='QoutePage'>
      <div className="QouteContent">
        <form action="">
          <div id="wizard">
          
              <h class="title-quatation">Quotations </h>
              <section>
              <Table  columns={columns} dataSource={dataSource} />;
              </section>

              {/* <section>
                  <div class="input-quote"> <input type="text" name="ticker" class="form-control" placeholder="Ticker"   /> </div>
                  <div class="input-quote"> <input type="text" name="lastPrice" class="form-control" placeholder="Last Price" /> </div>
                  <div class="input-quote"> <input type="text" name="bidPrice" class="form-control" placeholder="Bid Price" /> </div>
                  <div class="input-quote"> <input type="text" name="bidSize" class="form-control" placeholder="Bid Size" /> </div>
                  <div class="input-quote"> <input type="text" name="askPrice" class="form-control" placeholder="Ask Price" /> </div>
                  <div class="input-quote"> <input type="text" name="askSize" class="form-control" placeholder="Ask Size" /> </div>
                  <div> <button type="submit" onClick="handleSubmit()"></button>Add Quote</div>
              </section> */}
              
          </div>
        </form>
      </div>
    </div>
  )
}
