from appium import webdriver
from appium.webdriver.common.mobileby import MobileBy
from time import sleep


gmail_caps = {
    "platformName": "Android",
    "platformVersion": "11", 
    "deviceName": "Android Emulator",
    "automationName": "UiAutomator2",
    "appPackage": "com.google.android.gm",
    "appActivity": "com.google.android.gm.ConversationListActivityGmail",
    "noReset": True
}
driver = webdriver.Remote("http://127.0.0.1:4723/wd/hub", gmail_caps)
sleep(5)


try:
    compose_btn = driver.find_element(MobileBy.ACCESSIBILITY_ID, "Compose")
    compose_btn.click()
    sleep(2)
except:
    print("Compose button not found")

# Enter recipient email address
try:
    to_field = driver.find_element(MobileBy.XPATH, "//android.widget.MultiAutoCompleteTextView")
    to_field.send_keys("example@example.com")
    sleep(1)
except:
    print("To field not found")


try:
    subject_field = driver.find_element(MobileBy.XPATH, "//android.widget.EditText[@text='Subject']")
    subject_field.send_keys("Test Draft")
    sleep(1)
except:
    print("Subject field not found")


try:
    message_field = driver.find_element(MobileBy.XPATH, "//android.widget.EditText[contains(@text, 'Compose email')]")
    message_field.send_keys("This is a test draft email created using Appium.")
    sleep(2)
except:
    print("Message field not found")


driver.back()
sleep(1)
driver.back()
sleep(3)

print("Draft saved.")
driver.quit()