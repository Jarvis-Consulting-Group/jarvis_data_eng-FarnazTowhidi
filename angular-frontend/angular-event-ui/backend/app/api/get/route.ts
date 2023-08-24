import { promises as fs } from "fs";
import  path  from 'path';

export async function GET ()  {
  const jsonDirectory = path.join(process.cwd(), 'app/api');
  const jsonEvent = await fs.readFile(jsonDirectory + '/event.json', 'utf8');  

  return new Response(jsonEvent, {
    headers: {
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET',
      'Access-Control-Allow-Headers': 'Content-Type',
    },
  });
}