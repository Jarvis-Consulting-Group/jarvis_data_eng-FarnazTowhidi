import eventsData from './events.json';

export default function handler(req, res) {
  if (req.method === 'GET') {
    res.status(200).json(eventsData);
  } else if (req.method === 'POST') {
    const newEvent = req.body;
    console.log (newEvent)
    eventsData.push(newEvent);
    res.status(201).json(newEvent);
  } else {
    res.status(405).json({ message: 'Method Not Allowed' });
  }
}