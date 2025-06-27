from fastapi import FastAPI

from app.api.endpoint import root_router, api_router

app = FastAPI()

app.include_router(api_router, prefix="/api")
app.include_router(root_router)
