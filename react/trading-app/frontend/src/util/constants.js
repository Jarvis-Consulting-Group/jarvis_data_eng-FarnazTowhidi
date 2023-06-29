
export const BACKEND_URL = process.env.REACT_APP_BACKEND_URL || "http://localhost:3001";

export const tradersUrl = BACKEND_URL + "/api/traders/";
export const deleteTraderUrl = BACKEND_URL + "/api/traders/";
export const createTraderUrl = BACKEND_URL + "/api/traders/";
export const dailyListQuotesUrl = BACKEND_URL + "/quote/dailyList";
export const traderAccountUrl = BACKEND_URL + "/dashboard/profile/traderId/";
export const depositFundsUrl = BACKEND_URL + "/trader/deposit/traderId/";
export const withdrawFundsUrl = BACKEND_URL + "/trader/withdraw/traderId/";
//export const tradersUrl = BACKEND_URL + "/dashboard/traders";
//export const deleteTraderUrl = BACKEND_URL + "/trader/traderId";
//export const createTraderUrl = BACKEND_URL + "/trader";