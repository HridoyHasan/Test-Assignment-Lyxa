from appium import webdriver
from appium.webdriver.common.mobileby import MobileBy
from time import sleep
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
import random


chrome_caps = {
    "platformName": "Android",
    "platformVersion": "11",  
    "deviceName": "Android Emulator",
    "automationName": "UiAutomator2",
    "browserName": "Chrome",
    "noReset": True
}

driver = webdriver.Remote("http://127.0.0.1:4723/wd/hub", chrome_caps)
wait = WebDriverWait(driver, 20)

try:
    driver.get("https://www.automationexercise.com/products")
    sleep(5)

    for _ in range(3):  # scroll multiple times for more products
        driver.execute_script("window.scrollBy(0, 800);")
        sleep(2)

  
    product_links = driver.find_elements(By.XPATH, "//a[contains(text(),'View Product')]")

    if product_links:
        random_product = random.choice(product_links)
        product_name = random_product.get_attribute("href")
        sleep(5)
        print(f"Opening product: {product_name}")
        random_product.click()
        sleep(3)
        print("Random product opened.")

        driver.execute_script("window.scrollBy(0, 1200);")
        sleep(5)
        print("Final scroll done.")
        
        
    else:
        print("No products found on the page.")

        

except Exception as e:
    print(f"Chrome/product step failed: {e}")

driver.quit()