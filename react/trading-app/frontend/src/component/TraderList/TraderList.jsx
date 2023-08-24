import React, { useState } from 'react'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import axios from 'axios';
import {deleteTraderUrl } from '../../util/constants'

export default function TraderList({traders,setTraders}) {


async function DeleteTrader(id) {
  const response = await axios.delete (`${deleteTraderUrl}${id}`) 
  //setTraders ( traders.filter ((trader)=>trader.id!==id));
  setTraders ( response.data);
}

  return (
  <>
    <TableContainer >
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell align="right">Firstname</TableCell>
            <TableCell align="right">Lastname</TableCell>
            <TableCell align="right">Email</TableCell>
            <TableCell align="right">Date of Birth(s)</TableCell>
            <TableCell align="right">Country</TableCell>
            <TableCell align="right">Action</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {traders.map((trader) => (
            <TableRow key={trader?.key}>
              <TableCell align="right">{trader?.firstName}</TableCell>
              <TableCell align="right">{trader?.lastName}</TableCell>
              <TableCell align="right">{trader?.email}</TableCell>
              <TableCell align="right">{trader?.dob}</TableCell>
              <TableCell align="right">{trader?.country}</TableCell>
              <TableCell align="right"><button onClick={()=>DeleteTrader(trader?.id)}>Delete Trader</button></TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </>   
  )
}
