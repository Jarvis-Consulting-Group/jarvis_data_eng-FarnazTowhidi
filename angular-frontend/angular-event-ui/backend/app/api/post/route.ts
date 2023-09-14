import { NextResponse } from 'next/server';
import { promises as fs } from "fs";
import  path  from 'path';
 

export async function POST(request:Request) {
  const newEvent = await request.json()
  const jsonDirectory = path.join(process.cwd(), 'app/api');
  const jsonEvent = await fs.readFile(jsonDirectory + '/event.json', 'utf8');  
  const events =  (JSON.parse(jsonEvent))
  events.push(newEvent)
  await fs.writeFile(jsonDirectory + '/event.json', JSON.stringify(events));
   return NextResponse.json(events, {
    headers: {
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Methods': 'POST',
      'Access-Control-Allow-Headers': 'Content-Type',
      'Access-Control-Max-Age': '86400',
    },
  });
}
